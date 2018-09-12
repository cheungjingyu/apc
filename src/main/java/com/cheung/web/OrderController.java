package com.cheung.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Money;
import com.cheung.pojo.Order;
import com.cheung.pojo.OrderQuery;
import com.cheung.service.MenuService;
import com.cheung.service.OrderService;
import com.cheung.utils.AjaxResult;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private MenuService menuService;
	
	/**
	 * 分页list
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/list.do")
	public ModelAndView noticeList(Integer pageNum)
	{
		PageInfo<Order> pageInfo = null;
		if(pageNum==null)
		{
			pageInfo =  orderService.selectAll();
		}else{
			pageInfo =  orderService.selectAll(pageNum);
		}
		return new ModelAndView("admin/order","pageInfo",pageInfo);
	}
	
	/**
	 * 分页查询search
	 * @param orderQuery
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/search.do")
	public ModelAndView noticeSearch(HttpServletRequest request, OrderQuery orderQuery,Integer pageNum)
	{
		
		PageInfo<Order> pageInfo = null;
		if(pageNum==null)
		{
			pageInfo =  orderService.selectAllByOrder(orderQuery);
		}else{
			orderQuery = (OrderQuery)request.getSession().getAttribute("orderQuery");
			pageInfo = orderService.selectAllByOrder(pageNum, orderQuery);
		}
		request.getSession().setAttribute("orderQuery", orderQuery);
		return new ModelAndView("admin/order_search","pageInfo",pageInfo);
	}
	
	@RequestMapping("/statistic.do")
	public ModelAndView noticeStatistic(HttpServletRequest request, Integer pageNum)
	{
		PageInfo<Money> pageInfo = null;
		if(pageNum==null)
		{
			pageInfo = menuService.todayMenu(request);
		}else{
			pageInfo = menuService.todayMenu(request, pageNum);
		}
		return new ModelAndView("admin/order_statistic","pageInfo",pageInfo);
	}
	
	@RequestMapping("/orderY.do")
	public @ResponseBody AjaxResult orderY(Integer id)
	{
		if(id==null||id==0)
		{
			return AjaxResult.errorInstance("确认订单失败");
		}
		orderService.orderY(id);
		return AjaxResult.successInstance("确认订单");
	}
	
	@RequestMapping("/orderN.do")
	public @ResponseBody AjaxResult orderN(Integer id)
	{
		if(id==null||id==0)
		{
			return AjaxResult.errorInstance("取消订单失败");
		}
		orderService.orderN(id);
		return AjaxResult.successInstance("取消订单成功");
	}

}
