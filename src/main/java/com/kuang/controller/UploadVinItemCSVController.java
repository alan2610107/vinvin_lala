package com.kuang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinItemwithLocationandCategory;
import com.kuang.service.VinService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@Controller
@RequestMapping("/rest/kafka")
public class UploadVinItemCSVController {
    @Autowired
    private KafkaTemplate<String, VinItemwithLocationandCategory> kafkaTemplateVinItem;

    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @RequestMapping("/toupload")
    public String toUpload(Model model, HttpServletRequest request){
        String state = request.getParameter("state");
        HashMap<String, String> warehouseMap = vinService.getWarehouseMap();
        model.addAttribute("state",state);
        model.addAttribute("warehouseMap", warehouseMap);
        return "uploadpage";
    }
    @RequestMapping("/uploadkafka1321")
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
            openCSVReader.readNext();//忽略第一行
            while((record = openCSVReader.readNext()) != null){
                VinItem vinItem = new VinItem();

                vinItem.setItemName(record[0]);
                vinItem.setBrand(record[1]);
                vinItem.setItemCount(Integer.parseInt(record[2]));
                vinItem.setSinglePrice(Double.parseDouble(record[3]));
                vinItem.setTotalPrice(Double.parseDouble(record[4]));
                vinItem.setCategory(type);
                vinItem.setMemo("");
                vinService.checkIfExistandAddinAllItem(vinItem);
                VinItemwithLocationandCategory vinItemwithLocationandCategory = new VinItemwithLocationandCategory(vinItem);
                vinItemwithLocationandCategory.setCategory(type);
                vinItemwithLocationandCategory.setLocation(location);
                System.out.println(vinItemwithLocationandCategory);
                kafkaTemplateVinItem.sendDefault(vinItemwithLocationandCategory.getId(),vinItemwithLocationandCategory);

            }

            return "redirect:/toupload?state=succeed";

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return "redirect:/toupload?state=fail";
        }


    }

}
