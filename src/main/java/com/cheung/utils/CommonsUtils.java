package com.cheung.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class CommonsUtils {

	public static String getNowTime()
	{
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
	}
	public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
	public static String getNowDay()
	{
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
	}
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
