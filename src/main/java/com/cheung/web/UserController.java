package com.cheung.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Order;
import com.cheung.pojo.User;
import com.cheung.service.UserService;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.JedisUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 个人中心，，，，需要完善
	 * 
	 * @return
	 */
	@RequestMapping("/center.do")
	public ModelAndView center(HttpServletRequest request) {
		return new ModelAndView("qiantai/center");
	}

	/**
	 * 登陆页面
	 */
	@RequestMapping("/login.do")
	public ModelAndView login() {
		return new ModelAndView("qiantai/login");
	}

	/**
	 * login Submit
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public @ResponseBody AjaxResult login(HttpServletRequest request, User user) {
		request.getSession().removeAttribute("user");
		user = userService.login(user);
		if (user == null) {
			return AjaxResult.errorInstance("用户名或密码错误");
		}
		request.getSession().setAttribute("user", user);
		JedisUtils.setex("QT_keepOnline_" + request.getSession().getId(), 60 * 60 * 24, user.getId() + "");

		// 分配购物车
		List<Order> cart = new ArrayList<>();
		request.getSession().setAttribute("cart", cart);
		//金额...未加
		return AjaxResult.successInstance("登陆成功");
	}

	/**
	 * registerPage
	 * 
	 * @return
	 */
	@RequestMapping("/register.do")
	public ModelAndView register() {
		return new ModelAndView("qiantai/reg");
	}

	/**
	 * 注册处理
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public @ResponseBody AjaxResult register(HttpServletRequest request, User user) {
		User param = userService.selectOneByName(user.getName());
		if (param != null) {
			return AjaxResult.errorInstance("用户名已经存在");
		}
		JedisUtils.del("keepOnline_" + request.getSession().getId());
		request.removeAttribute("user");
		userService.insert(user);
		return AjaxResult.successInstance("注册成功");
	}

	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request)
	{
		
		JedisUtils.del("keepOnline_"+request.getSession().getId());
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public @ResponseBody AjaxResult update(HttpServletRequest request, User user) {
		userService.update(user);
		user = userService.selectOneById(user.getId());
		request.getSession().setAttribute("user", user);
		JedisUtils.sadd("keepOnline_" + request.getSession().getId(), user.getId() + "");
		return AjaxResult.successInstance("修改成功");
	}
}
