package com.cheung.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.utils.AjaxResult;

/**
 * 用与打开与业务逻辑无关的展示页面。
 * @author Cheungjingyu
 *
 */
@Controller
public class OtherController {

	
	
	@RequestMapping("/admin_top.do")
	public ModelAndView adminTop()
	{
		return new ModelAndView("admin/admin_top");
	}
	@RequestMapping("/admin_left.do")
	public ModelAndView adminLeft()
	{
		return new ModelAndView("admin/admin_left");
	}
	@RequestMapping("/admin_right.do")
	public ModelAndView menus()
	{
		return new ModelAndView("admin/admin_right");
	}
	@ExceptionHandler(MultipartException.class)
	public @ResponseBody AjaxResult handleException(MultipartException ex) {
	    return AjaxResult.errorInstance("上传文件的大小不能超过20M");
	}
	
	/**
	 * 自动到前台
	 */
	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("redirect:/qiantai/index.do");
	}
}
