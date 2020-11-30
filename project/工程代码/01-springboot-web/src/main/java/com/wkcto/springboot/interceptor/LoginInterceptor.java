package com.wkcto.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:LoginInterceptor
 * <p>
 * Package:com.wkcto.springboot.interceptor
 * Description:
 *
 * @Date:2018/8/7 11:03
 * @Author:GanHoL
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入controller之前执行该方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //业务处理（省略）

        System.out.println("进入了登录拦截器......");

        return true;

    }
}