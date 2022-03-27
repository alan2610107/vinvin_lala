package com.kuang.controller;

import com.kuang.pojo.*;
import com.kuang.service.FileUploadService;
import com.kuang.service.VinService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/invoice")
public class InvoiceSaveController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private FileUploadService fileUploadService;

    //跳轉到新增頁面
    @RequestMapping("/toAdd")
    public String toAdd(Model model, @RequestParam String location, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            vinService.toaddItem(location,"invoice","add","水果運單",model,null);
            return "addFruitInvoice";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    public void autoAddFruitInvoiceSec(FruitInvoice invoice){
        taskExecutor.submit(new Runnable() {
            @Override
            public void run() {
                String month = invoice.getMonth();
                String store = invoice.getLocation();
                String supplier = invoice.getSupplier();
                String id = store + "_" + supplier + "_" + month;
                double invoicePrice = invoice.getPrice();;
                int ifExist = 0;
                ifExist = vinService.ifExistFruitInvoiceSecID(id);
                if(ifExist > 0){
                    FruitInvoiceSec fruitInvoiceSecOrigin = vinService.queryFruitInvoiceSecbyID(id);
                    fruitInvoiceSecOrigin.setTotalPrice(fruitInvoiceSecOrigin.getTotalPrice() + invoicePrice);
                    vinService.updateFruitInvoiceSec(fruitInvoiceSecOrigin);
                }else {
                    vinService.addFruitInvoiceSec(new FruitInvoiceSec(id, supplier, store, invoicePrice, month));
                }

            }
        });
    }

    //insert
    @RequestMapping("/add")
    public String add(FruitInvoice invoice, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, @RequestParam String location, HttpSession session, Model model) throws IOException, InterruptedException {
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            System.out.println("add=>FruitInvoice"+invoice);
            String invoiceid = UUID.randomUUID().toString().replace("-","");
            String time = vinService.getDateTime();
            invoice.setInvoiceid(invoiceid);
            invoice.setTime(time);
            invoice.setLocation(location);
            invoice.setMonth(vinService.getMonth());
            autoAddFruitInvoiceSec(invoice);
            vinService.addFruitInvoiceandFile(invoice,file,request);
            return "redirect:/invoice/show?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    //顯示資料
    @RequestMapping("/show")
    public String showInvoice(Model model, HttpSession session, @RequestParam String location){
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            List<FruitInvoice> fruitInvoices = vinService.queryFruitInvoice(location);
            String realname = vinService.queryRealWarehouseName(location).getRealname();
            model.addAttribute("fruitInvoices",fruitInvoices);
            model.addAttribute("warehouse",realname);
            model.addAttribute("mainWarehouse","invoice");
            model.addAttribute("logLocation","show?location="+location);
            model.addAttribute("location",location);
            return "showFruitInvoice";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    //顯示圖片
    @RequestMapping("/showphoto")
    public String showPhoto(@RequestParam String invoiceid, Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            String filepath = vinService.queryFileTypebyid(invoiceid).getFilepath();
            model.addAttribute("filepath", filepath);
            return "showInvoicephoto";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    //編輯頁面
    @RequestMapping("/toedit")
    public String toedit(@RequestParam String invoiceid, Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            FruitInvoice fruitInvoice = vinService.queryFruitInvoicebyInvoiceid(invoiceid);
            String filepath = vinService.queryFileTypebyid(invoiceid).getFilepath();
            model.addAttribute("fruitInvoice", fruitInvoice);
            model.addAttribute("type", "水果運單");
            model.addAttribute("filepath",filepath);
            return "editFruitInvoice";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    //編輯
    @RequestMapping("/edit")
    public String edit(FruitInvoice invoice, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpSession session, Model model) throws IOException {
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            System.out.println(invoice);
            FruitInvoice fruitInvoiceOrigin = vinService.queryFruitInvoicebyInvoiceid(invoice.getInvoiceid());
            FruitInvoice toFruitInvoiceSec = new FruitInvoice(invoice);
            toFruitInvoiceSec.setPrice(invoice.getPrice() - fruitInvoiceOrigin.getPrice());
            autoAddFruitInvoiceSec(toFruitInvoiceSec);
            vinService.updateFruitInvoice(invoice);
            if(!file.isEmpty()){
                taskExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            fileUploadService.fileUpload(file,request,invoice.getInvoiceid(),"/fruitInvoice");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }

            return "redirect:/invoice/show?location="+invoice.getLocation();
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String invoiceid, HttpSession session, Model model, @RequestParam String location){
        User user = (User)session.getAttribute("user");
        if (user.getLevel() == 1000){
            vinService.deleteFruitInvoicebyInvoiceID(invoiceid);
            return "redirect:/invoice/show?location="+location;
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

}
