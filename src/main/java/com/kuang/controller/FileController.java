package com.kuang.controller;

import com.kuang.pojo.VinItem;
import com.kuang.service.VinService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {
    /*
     * 采用file.Transto 来保存上传的文件
     */
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @RequestMapping("/toupload")
    public String toUpload(Model model, HttpServletRequest request){
        String state = request.getParameter("state");
        model.addAttribute("state",state);
        return "uploadpage";
    }
    @RequestMapping("/upload1321")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/uploadCSV");
        String location = request.getParameter("Warehouse");
        String type = request.getParameter("Type");
        System.out.println(file);
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));

        try {

            String filePath = request.getServletContext().getRealPath("/uploadCSV")+"/"+file.getOriginalFilename();
            FileReader fileReader = new FileReader(filePath);

            CSVReader openCSVReader = new CSVReader(fileReader);
            String[] record;

            System.out.println(location);
            System.out.println(type);
            while((record = openCSVReader.readNext()) != null){
                VinItem vinItem = new VinItem();
                vinItem.setItemName(record[0]);
                vinItem.setBrand(record[1]);
                vinItem.setItemCount(Integer.parseInt(record[2]));
                vinItem.setSinglePrice(Double.parseDouble(record[3]));
                vinItem.setTotalPrice(Double.parseDouble(record[4]));
                vinItem.setMemo("");
                vinService.checkIfExistandAddinAllItem(vinItem);
                System.out.println(vinItem);
                vinService.addVinItem(location,type,vinItem);
//                switch (type){
//                    case "tool":
//                        switch (location){
//                            case "main0":
//                                vinService.addIteminMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addIteminMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addIteminMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addIteminShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addIteminShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addIteminShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addIteminShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addIteminShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addIteminShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addIteminShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addIteminShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addIteminShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addIteminShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addIteminShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addIteminShop12(vinItem);
//                                break;
//                        }
//                        break;
//                    case "smalltool":
//                        switch (location){
//                            case "main0":
//                                vinService.addSmallIteminMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addSmallIteminMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addSmallIteminMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addSmallIteminShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addSmallIteminShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addSmallIteminShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addSmallIteminShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addSmallIteminShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addSmallIteminShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addSmallIteminShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addSmallIteminShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addSmallIteminShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addSmallIteminShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addSmallIteminShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addSmallIteminShop12(vinItem);
//                                break;
//
//                        }
//                        break;
//                    case "food":
//                        switch (location){
//                            case "main0":
//                                vinService.addFoodinMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addFoodinMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addFoodinMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addFoodinShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addFoodinShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addFoodinShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addFoodinShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addFoodinShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addFoodinShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addFoodinShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addFoodinShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addFoodinShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addFoodinShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addFoodinShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addFoodinShop12(vinItem);
//                                break;
//
//                        }
//                        break;
//                    case "commercialthing":
//                        switch (location){
//                            case "main0":
//                                vinService.addcommercialIteminMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addcommercialIteminMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addcommercialIteminMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addcommercialIteminShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addcommercialIteminShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addcommercialIteminShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addcommercialIteminShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addcommercialIteminShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addcommercialIteminShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addcommercialIteminShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addcommercialIteminShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addcommercialIteminShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addcommercialIteminShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addcommercialIteminShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addcommercialIteminShop12(vinItem);
//                                break;
//
//                        }
//                        break;
//                    case "other":
//                        switch (location){
//                            case "main0":
//                                vinService.addothersinMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addothersinMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addothersinMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addothersinShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addothersinShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addothersinShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addothersinShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addothersinShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addothersinShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addothersinShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addothersinShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addothersinShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addothersinShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addothersinShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addothersinShop12(vinItem);
//                                break;
//                        }
//                        break;
//                }

            }

            return "redirect:/toupload?state=succeed";

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return "redirect:/toupload?state=fail";
        }


    }

    //下載
    @RequestMapping(value="/download")
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{
        //要下载的图片地址
        String  path = request.getServletContext().getRealPath("/upload");
        String  fileName = "cv_new_v3_ch2.pdf";

        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }

}
