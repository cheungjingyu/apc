package com.cheung.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.cheung.pojo.User;
import com.cheung.service.UserService;
import com.cheung.utils.JedisUtils;

public class QTKeepOnlineInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null)
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
			user = userService.selectOneById(Integer.parseInt(userId));
			if(user!=null)
			{
				request.getSession().setAttribute("user", user);
			}
		}
		
		if(user!=null)
		{
			JedisUtils.setex("QT_keepOnline_"+request.getSession().getId(), 60*60*24, user.getId()+"");
		}
		return true;
	}
}
