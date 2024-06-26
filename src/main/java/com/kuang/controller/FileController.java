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
