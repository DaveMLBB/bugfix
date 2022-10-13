package com.example.demo.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Value("${key:key}")
    private String key;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key1 = request.getHeader("keykey");

        if (!request.getRequestURI().matches("(\\/auth\\/go)")) return true;

        if(key1.equalsIgnoreCase(key)){
                return true;

            }else {
                response.setStatus(401);
                return false;
            }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
