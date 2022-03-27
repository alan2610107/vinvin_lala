package com.kuang.controller;

import com.kuang.service.VinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemUpdateDetailController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @RequestMapping("/updatedetail")
    public String showpage(Model model){
        model.addAttribute("warehouse", "更新日誌");
        return "systemUpdateDetail";
    }
}
