package com.cheung.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Menu;
import com.cheung.pojo.Order;
import com.cheung.pojo.User;
import com.cheung.service.MenuService;
import com.cheung.service.OrderService;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.CommonsUtils;

@Controller
@RequestMapping("/qtcart")
public class QTCartController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/index.do")
	public ModelAndView cart()
	{
		return new ModelAndView("qiantai/shoppingcar");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/add.do")
	public @ResponseBody AjaxResult add(HttpServletRequest request, Integer id)
	{
		List<Order> cart = (List<Order>) request.getSession().getAttribute("cart");
		if(cart!=null)
		{
			for(Order param :cart)
			{
				if(param.getMenuid().equals(id+""))
				{
					param.setMenusum(Integer.parseInt(param.getMenusum())+1+"");
					return AjaxResult.successInstance("加入购物车");
				}
			}
		}
		Menu menu = menuService.selectOneById(id);
		Order order = new Order();
		order.setMenu(menu);
		order.setMenuid(id+"");
		
		User user = (User) request.getSession().getAttribute("user");
		order.setUser(user);
		order.setUserid(user.getId()+"");
		order.setTimes(CommonsUtils.getNowTime());
		order.setDelivery("0");
		order.setMenusum("1");
		cart.add(order);
		return AjaxResult.successInstance("加入购物车");
		
	}
	
	/**
	 * 单个取消
	 * @param request
	 * @param id menuId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete.do")
	public @ResponseBody AjaxResult delete(HttpServletRequest request, Integer id)
	{
		List<Order> cart = (List<Order>) request.getSession().getAttribute("cart");
		for(Order order : cart)
		{
			if(order.getMenuid().equals(id+""))
			{
				cart.remove(order);
				return AjaxResult.successInstance("取消成功");
			}
		}
		return AjaxResult.errorInstance("请尝试重新刷新页面");
	}
	
	/**
	 * 全部取消
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAll.do")
	public @ResponseBody AjaxResult deleteAll(HttpServletRequest request)
	{
		request.getSession().setAttribute("cart", new ArrayList<Order>());
		return AjaxResult.successInstance("全部取消成功");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/submit.do")
	public @ResponseBody AjaxResult submit(HttpServletRequest request)
	{
		List<Order> cart = (List<Order>) request.getSession().getAttribute("cart");
		orderService.InsertAll(cart);
		request.getSession().setAttribute("cart", new ArrayList<Order>());
		return AjaxResult.successInstance("提交成功");
	}
}
