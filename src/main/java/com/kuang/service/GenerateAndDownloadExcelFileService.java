package com.kuang.service;

import com.kuang.pojo.VinCheck;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Marker;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author Chi-Lin Wu
 * @apiNote Generate and download Excel file
 */
@Service
@Slf4j
public class GenerateAndDownloadExcelFileService {

    /**
     *
     * @param t
     * @param <T>
     * @return The list contains value and type
     * @apiNote Get value and type list by reflect
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     *
     */
    public <T> List<List<String>> getTypeAndValue(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<? extends Object> tClass = t.getClass();
        Field[] declaredFields = tClass.getDeclaredFields();
        List<List<String>> outputList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        List<String> typeList = new ArrayList<>();
        Field field = null;
        String name = null;
        Method m = null;
        for (int i = 0; i < declaredFields.length; i++) {
            field = declaredFields[i];
            name = declaredFields[i].getName(); //name的第一個字母大寫
            name = name.replaceFirst(name.substring(0,1),name.substring(0,1).toUpperCase(Locale.ROOT));
            m = tClass.getMethod("get"+name);
            String type = field.getGenericType().toString();
            valueList.add(m.invoke(t).toString());
            typeList.add(type);
        }
        outputList.add(valueList);
        outputList.add(typeList);


        return outputList;
    }

    /**
     *
     * @apiNote Generate Excel file and download it. This is the general one, accept all types of containMap
     * @param response
     * @param reportName
     * @param containMap This map is including sheet name and data
     * @param headers This is the sheet header
     * @param <T>
     * @throws IOException
     *
     */
    public <T>  void generalDownloadExcel(HttpServletResponse response, String reportName, Map<String, List<T>> containMap, String[] headers) throws IOException {
        try {
            log.info("Generate and Download Excel Start");
            response.reset();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Encoding", "UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(reportName, "UTF-8"));
            XSSFWorkbook workbook = new XSSFWorkbook();
            for (String sheetName : containMap.keySet()) {
                Sheet sheet = workbook.createSheet(sheetName);
                sheet.setColumnWidth(0, 10000);
                sheet.setColumnWidth(1, 3000);
                sheet.setColumnWidth(2, 3000);
                sheet.setColumnWidth(3, 3000);
                sheet.setColumnWidth(4, 3000);
                sheet.setColumnWidth(5, 3000);

                Row header = sheet.createRow(0);

//        CellStyle headerStyle = workbook.createCellStyle();
//        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
//        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

//        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
//        font.setFontName("Arial");
//        font.setFontHeightInPoints((short) 16);
//        font.setBold(true);
//        headerStyle.setFont(font);
                Cell headerCell = null;
                for (int i = 0; i < headers.length; i++) {
                    headerCell = header.createCell(i);
                    headerCell.setCellValue(headers[i]);
                    //headerCell.setCellStyle(headerStyle);
                }

                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                List<T> vinCheckList = containMap.get(sheetName);
                int i = 1;
                Cell cell = null;
                String difference = null;
                for (T vinCheck : vinCheckList) {
                    List<List<String>> typeAndValueList = getTypeAndValue(vinCheck);
                    List<String> typeList = typeAndValueList.get(1);
                    List<String> valueList = typeAndValueList.get(0);
//                    System.out.println(typeList);
//                    System.out.println(valueList);
                    Row row = sheet.createRow(i);
                    for (int j = 0; j < valueList.size(); j++) {
                        cell = row.createCell(j);
                        String type = typeList.get(j);
                        String value = valueList.get(j);
//                        System.out.println(value);
//                        System.out.println(type);
                        switch(type){
                            case "class java.lang.String":
                                cell.setCellValue(value);
                                break;
                            case "int":
                                cell.setCellValue(Integer.parseInt(value));
                                break;
                            case "boolean":
                                cell.setCellValue(Boolean.parseBoolean(value));
                                break;
                            case "double":
                                cell.setCellValue(Double.parseDouble(value));
                                break;
                            default:
                                log.error("No match!!!");
                        }
                        cell.setCellStyle(style);
                    }
                    i++;
                }
            }
            workbook.write(response.getOutputStream());
            workbook.close();
            log.info("Generate and Download Excel Finish");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR!!!!");

        }
    }

    /**
     *
     * @apiNote Generate Excel file and download it.
     * @param response
     * @param reportName
     * @param vinCheckMap This map is including sheet name and data
     * @param headers This is the sheet header
     * @throws IOException
     */
    public void downloadExcel(HttpServletResponse response, String reportName, Map<String, List<VinCheck>> vinCheckMap, String[] headers) throws IOException {
        try {
            log.warn("Generate and Download Excel Start");
//            System.out.println("=====Start!!=====");
            response.reset();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Encoding", "UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(reportName, "UTF-8"));
            XSSFWorkbook workbook = new XSSFWorkbook();
            for (String sheetName : vinCheckMap.keySet()) {
                Sheet sheet = workbook.createSheet(sheetName);
                sheet.setColumnWidth(0, 10000);
                sheet.setColumnWidth(1, 3000);
                sheet.setColumnWidth(2, 3000);
                sheet.setColumnWidth(3, 3000);
                sheet.setColumnWidth(4, 3000);
                sheet.setColumnWidth(5, 3000);

//        CellStyle headerStyle = workbook.createCellStyle();
//        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
//        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

//        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
//        font.setFontName("Arial");
//        font.setFontHeightInPoints((short) 16);
//        font.setBold(true);
//        headerStyle.setFont(font);
                Row header = sheet.createRow(0);
                Cell headerCell = null;
                for (int i = 0; i < headers.length; i++) {
                    headerCell = header.createCell(i);
                    headerCell.setCellValue(headers[i]);
                    //headerCell.setCellStyle(headerStyle);
                }

                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                List<VinCheck> vinCheckList = vinCheckMap.get(sheetName);
                int i = 1;
                Cell cell = null;
                String difference = null;
                for (VinCheck vinCheck : vinCheckList) {
                    Row row = sheet.createRow(i);
                    cell = row.createCell(0);
                    cell.setCellValue(vinCheck.getItemName());
                    cell.setCellStyle(style);

                    cell = row.createCell(1);
                    cell.setCellValue(vinCheck.getBrand());
                    cell.setCellStyle(style);

                    cell = row.createCell(2);
                    cell.setCellValue(vinCheck.getCheckitemCount());
                    cell.setCellStyle(style);

                    cell = row.createCell(3);
                    cell.setCellValue(vinCheck.getRealitemCount());
                    cell.setCellStyle(style);

                    cell = row.createCell(4);
                    cell.setCellValue(vinCheck.getTime());
                    cell.setCellStyle(style);

                    if (vinCheck.getIfmatch().equals("same")) {
                        difference = "一樣";
                    } else if (vinCheck.getIfmatch().equals("less")) {
                        difference = "少了" + vinCheck.getDifference();
                    } else {
                        difference = "多了" + vinCheck.getDifference();
                    }

                    cell = row.createCell(5);
                    cell.setCellValue(difference);
                    cell.setCellStyle(style);
                    i++;
                }

            }

            workbook.write(response.getOutputStream());
            workbook.close();
            log.warn("Generate and Download Excel Finish");
        }catch (Exception e){
            log.error("ERROR!!!!");
        }

    }

}
