package com.kuang.interceptor;

import com.kuang.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();
        // login.jsp或登录请求放行，不拦截
        if (url.indexOf("/toLogin") >= 0 || url.indexOf("/login") >= 0 || url.indexOf("/vinvinIcon.svg") >= 0) {
            return true;
        }
        // 获取 session
        HttpSession session = request.getSession();
//        Object obj =
        User user = (User) session.getAttribute("user");;
        if(user != null){
            log.warn("LoginInterceptor名稱==>" + user.getUname());
            return true;
        }

//        if (obj != null){
//            System.out.println(obj);
//
//        }

        // 没有登录且不是登录页面，转发到登录页面，并给出提示错误信息
        request.setAttribute("msg", "还没登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
                response);
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub
    }

}
