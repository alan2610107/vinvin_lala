package com.kuang.controller;

import com.kuang.pojo.User;
import com.kuang.service.VinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
    /**
     * 登录页面初始化
     */

    @RequestMapping("/toLogin")
    public String initLogin(Model model) {
        return "login";
    }

    /**
     * 处理登录功能
     */
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
//        System.out.println("UserController==>" + user.getUname());
//        if ("admin".equals(user.getUname()) && "123456".equals(user.getUpwd())) {
//            user.setLevel(2);
//            session.setAttribute("user", user);
//            return "redirect:/mainWarehouse1/allItem";
//        } else {
//            model.addAttribute("msg", "用户名或密码错误，请重新登录！ ");
//            return "login";
//        }
        log.warn("UserController==>"+user.getUname());
        User member = vinService.queryUserInformation(user.getUname());
        if(member != null){
            if(member.getUpwd().equals(user.getUpwd())){
                // 登录成功，将用户信息保存到session对象中
                session.setAttribute("user", member);
                if(member.getLevel() == 1000){
                    return "redirect:/warehouse/allItem?location=main0";
                }else if(member.getLevel() == 1 || member.getLevel() == 500){
                    return "redirect:/warehouse/allItem?location=shop1";
                }else if(member.getLevel() == 2){
                    return "redirect:/warehouse/allItem?location=shop2";
                }else if(member.getLevel() == 3){
                    return "redirect:/warehouse/allItem?location=shop3";
                }else if(member.getLevel() == 4 ||member.getLevel() == 501){
                    return "redirect:/warehouse/allItem?location=shop4";
                }else if(member.getLevel() == 5){
                    return "redirect:/warehouse/allItem?location=shop5";
                }else if(member.getLevel() == 6){
                    return "redirect:/warehouse/allItem?location=shop6";
                }else if(member.getLevel() == 7){
                    return "redirect:/warehouse/allItem?location=shop7";
                }else if(member.getLevel() == 8){
                    return "redirect:/warehouse/allItem?location=shop8";
                }else if(member.getLevel() == 9){
                    return "redirect:/warehouse/allItem?location=shop9";
                }else if(member.getLevel() == 10){
                    return "redirect:/warehouse/allItem?location=shop10";
                }else if(member.getLevel() == 11){
                    return "redirect:/warehouse/allItem?location=shop11";
                }else if(member.getLevel() == 12){
                    return "redirect:/warehouse/allItem?location=shop12";
                }else if(member.getLevel() == 500){
                    return "redirect:/warehouse/allItem?location=shop10";
                }else {
                    model.addAttribute("msg", "密码错误，请重新登录！ ");
                    return "login";
                }

            }else {
                model.addAttribute("msg", "密码错误，请重新登录！ ");
                return "login";
            }
        }else {
            model.addAttribute("msg", "無此用戶！ ");
            return "login";
        }

    }

    /**
     * 跳转到主页面
     */
//    @RequestMapping("/main")
//    public String toMain() {
//        return "main";
//    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除 session
        session.invalidate();
        return "login";
    }

}
