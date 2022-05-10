package com.kuang.controller;

import com.alibaba.fastjson.JSONArray;
import com.kuang.pojo.User;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinLog;
import com.kuang.pojo.Warehouse;
import com.kuang.service.LogService;
import com.kuang.service.QueryLogService;
import com.kuang.service.VinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/log")
public class LogController extends HttpServlet {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private QueryLogService queryLogService;

    @Resource
    private LogService logService;

    List<VinLog> listItem;
    List<VinLog> listFood;
    List<VinLog> listSmallItem;
    List<VinLog> listCommercialthing;
    List<VinLog> listOther;


    @RequestMapping("/warehouse")
    public String listLog(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam String location) throws ServletException, IOException, ExecutionException, InterruptedException {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUname());
        int userLevel = user.getLevel();
        if (vinService.ifAccess(user,location)) {
            Future<List<VinLog>> futureTool = queryLogService.get(location, "tool", null);
            Future<List<VinLog>> futureSmallTool = queryLogService.get(location, "smalltool", null);
            Future<List<VinLog>> futureFood = queryLogService.get(location, "food", null);
            Future<List<VinLog>> futureCommercial = queryLogService.get(location, "commercialthing", null);
            Future<List<VinLog>> futureOther = queryLogService.get(location, "other", null);
            if(!futureTool.isDone() && !futureSmallTool.isDone() && !futureFood.isDone() && !futureCommercial.isDone() && !futureOther.isDone()){
                System.out.println("task has not finished, please wait!");
            }

            listItem = futureTool.get();
            listFood = futureFood.get();
            listSmallItem = futureSmallTool.get();
            listCommercialthing = futureCommercial.get();
            listOther = futureOther.get();
            System.out.println(listItem);
            System.out.println(listFood);
            System.out.println(listSmallItem);
            System.out.println(listCommercialthing);
            System.out.println(listOther);
            HashMap<String, String> locationHashMap = vinService.getWarehouseMap();
            model.addAttribute("locationHashMap", locationHashMap);
            model.addAttribute("listItem", listItem);
            model.addAttribute("listFood", listFood);
            model.addAttribute("listSmallItem", listSmallItem);
            model.addAttribute("listCommercialthing", listCommercialthing);
            model.addAttribute("listOther", listOther);
            String realname = vinService.queryRealWarehouseName(location).getRealname();
            model.addAttribute("warehouse", realname+"紀錄");
            model.addAttribute("mainWarehouse","log");
            model.addAttribute("logLocation", "warehouse?location="+location);
            model.addAttribute("location", location);
            model.addAttribute("categoryTool", "tool");
            model.addAttribute("categoryFood", "food");
            model.addAttribute("categorySmallTool", "smalltool");
            model.addAttribute("categoryCommercial", "commercialthing");
            model.addAttribute("categoryOther", "other");
            model.addAttribute("userLevel", userLevel);
            model.addAttribute("actionMap", vinService.getActionMap());

            return "allLog";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/warehouseifComplete")
    public String notCompletelistLog(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam String location, @RequestParam String ifComplete) throws ServletException, IOException, ExecutionException, InterruptedException {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUname());
        int userLevel = user.getLevel();
        if (vinService.ifAccess(user,location)) {
            Future<List<VinLog>> futureTool = queryLogService.get(location, "tool", ifComplete);
            Future<List<VinLog>> futureSmallTool = queryLogService.get(location, "smalltool", ifComplete);
            Future<List<VinLog>> futureFood = queryLogService.get(location, "food", ifComplete);
            Future<List<VinLog>> futureCommercial = queryLogService.get(location, "commercialthing", ifComplete);
            Future<List<VinLog>> futureOther = queryLogService.get(location, "other", ifComplete);
            if(!futureTool.isDone() && !futureSmallTool.isDone() && !futureFood.isDone() && !futureCommercial.isDone() && !futureOther.isDone()){
                System.out.println("task has not finished, please wait!");
            }

            listItem = futureTool.get();
            listFood = futureFood.get();
            listSmallItem = futureSmallTool.get();
            listCommercialthing = futureCommercial.get();
            listOther = futureOther.get();
            System.out.println(listItem);
            System.out.println(listFood);
            System.out.println(listSmallItem);
            System.out.println(listCommercialthing);
            System.out.println(listOther);
            HashMap<String, String> locationHashMap = vinService.getWarehouseMap();
            model.addAttribute("locationHashMap", locationHashMap);
            model.addAttribute("listItem", listItem);
            model.addAttribute("listFood", listFood);
            model.addAttribute("listSmallItem", listSmallItem);
            model.addAttribute("listCommercialthing", listCommercialthing);
            model.addAttribute("listOther", listOther);
            String realname = vinService.queryRealWarehouseName(location).getRealname();
            model.addAttribute("warehouse", realname+"紀錄");
            model.addAttribute("mainWarehouse","log");
            model.addAttribute("logLocation", "warehouse?location="+location);
            model.addAttribute("location", location);
            model.addAttribute("categoryTool", "tool");
            model.addAttribute("categoryFood", "food");
            model.addAttribute("categorySmallTool", "smalltool");
            model.addAttribute("categoryCommercial", "commercialthing");
            model.addAttribute("categoryOther", "other");
            model.addAttribute("userLevel", userLevel);

            return "allLog";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }


    @RequestMapping("/lookupsingleItem")
    public String lookupSingleItem(@RequestParam String location, @RequestParam String id, Model model, HttpSession session, @RequestParam String category){
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        if(vinService.ifAccess(user,location)){
            List<VinLog> vinLogList = logService.queryVinLog(id,location);
            VinItem vinItem = vinService.getVinItem(location, category, id);
            HashMap<String, String> locationHashMap = vinService.getWarehouseMap();
            model.addAttribute("locationHashMap", locationHashMap);
            model.addAttribute("vinLogList", vinLogList);
            String realname = vinService.queryRealWarehouseName(location).getRealname();
            model.addAttribute("location", realname);
            model.addAttribute("warehouse", "調閱紀錄");
            model.addAttribute("userLevel", userLevel);
            model.addAttribute("vinItem", vinItem);
            model.addAttribute("logLocation", location);

            return "lookupSingleItemLog";
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }



    }




}
