package com.cheung.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cheung.pojo.User;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.CommonsUtils;
import com.cheung.utils.JsonUtils;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
        //如果用户还没有登录，让用户去登录
        if (user == null) {
            //返回json格式的权限不足信息
            if (CommonsUtils.isEmpty(request.getHeader("x-requested-with"))) {
            	request.setAttribute("message", "请先登录");
                request.getRequestDispatcher("/WEB-INF/jsp/qiantai/login.jsp").forward(request, response);
           
            } else {
                response.getWriter().print(JsonUtils.toJson(AjaxResult.errorInstance("需要登录")));
            }
            return false;
        }
        return true;
	}
}
