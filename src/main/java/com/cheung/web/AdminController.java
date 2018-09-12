package com.cheung.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Admin;
import com.cheung.service.AdminService;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.JedisUtils;

/**
 * 控制后台，及与后台用户有管的逻辑
 * @author Cheungjingyu
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	/**
	 * 打开登陆页面
	 * @return
	 */
	@RequestMapping(value="login.do",method=RequestMethod.GET)
	public ModelAndView loginPage()
	{
		return new ModelAndView("admin/login");
	}
	
	/**
	 * 登陆页面验证
	 * 验证错误，返回当前页面并提示错误信息。
	 * 验证成功，将admin保存到session中，重定向到'/'
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public ModelAndView loginSubmit(HttpServletRequest request, Admin admin)
	{
		admin = adminService.login(admin);
		if(admin==null)
		{
			return new ModelAndView("admin/login","message","用户名或密码错误");
		}
		request.getSession().setAttribute("admin", admin);
		JedisUtils.setex("keepOnline_"+request.getSession().getId(), 60*60*24, admin.getId()+"");
		return new ModelAndView("redirect:/admin");
	}
	
	/**
	 * 当请求路径是'/admin'时，判断session中是否存在admin,
	 * 如果存在，则返回逐渐面，如果不存在，重定向登陆请求。
	 * @param req
	 * @return
	 */
	@RequestMapping(value={"/","/index.do"})
	public ModelAndView index(HttpServletRequest req)
	{
		Object admin = req.getSession().getAttribute("admin");
		if(admin==null)
		{
			return new ModelAndView("redirect:/admin/login.do");
		}
		return new ModelAndView("admin/index");
	}
	
	/**
	 * 管理员更新
	 * @return
	 */
	@RequestMapping("update.do")
	public ModelAndView update()
	{
		return new ModelAndView("/admin/admin_update");
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public @ResponseBody AjaxResult updateSubmit(HttpServletRequest request, Admin admin)
	{
		adminService.updatePwd(admin);
		request.getSession().removeAttribute("admin");
		JedisUtils.del("keepOnline_"+request.getSession().getId());
		return AjaxResult.successInstance("密码修改成功");
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request)
	{
		
		JedisUtils.del("keepOnline_"+request.getSession().getId());
		request.getSession().removeAttribute("admin");
		return new ModelAndView("redirect:/admin");
	}
}
