package com.cheung.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.cheung.pojo.Admin;
import com.cheung.service.AdminService;
import com.cheung.utils.JedisUtils;

public class KeepOnlineInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private AdminService adminService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin==null)
		{
			Cookie cookieJSessionId = WebUtils.getCookie(request, "JSESSIONID");
			if(cookieJSessionId==null)
			{
				return true;
			}
			String oldSessionId = cookieJSessionId.getValue();
			
			String userId = JedisUtils.get("keepOnline_"+oldSessionId);
			if(userId==null)
			{
				return true;
			}
			admin = adminService.getOne(Integer.parseInt(userId));
			if(admin!=null)
			{
				request.getSession().setAttribute("admin", admin);
			}
		}
		
		if(admin!=null)
		{
			JedisUtils.setex("keepOnline_"+request.getSession().getId(), 60*60*24, admin.getId()+"");
		}
		return true;
	}
}
