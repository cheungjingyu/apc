package com.cheung.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cheung.pojo.Admin;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.CommonsUtils;
import com.cheung.utils.JsonUtils;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		Admin adminUser = (Admin) request.getSession().getAttribute("admin");
        //如果用户还没有登录，让用户去登录
        if (adminUser == null) {
            //返回json格式的权限不足信息
            if (CommonsUtils.isEmpty(request.getHeader("x-requested-with"))) {
                response.getWriter().print("需要登录");
            } else {
                response.getWriter().print(JsonUtils.toJson(AjaxResult.errorInstance("需要登录")));
            }
            return false;
        }
        return true;
	}
}
