package com.cheung.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Order;
import com.cheung.pojo.OrderQuery;
import com.cheung.pojo.User;
import com.cheung.service.OrderService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/qtorder")
public class QTOrderController {

	@Autowired
	private OrderService orderService;
	
	
	/**
	 * 分页查询search
	 * @param orderQuery
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/myOrder.do")
	public ModelAndView noticeSearch(HttpServletRequest request, OrderQuery orderQuery,Integer pageNum)
	{
		PageInfo<Order> pageInfo = null;
		OrderQuery param = (OrderQuery) request.getSession().getAttribute("orderQuery");
		User user = (User)request.getSession().getAttribute("user");
		if(param==null)
		{
			//表示第一次进来
			orderQuery.setUserId(user.getId());
			pageInfo = orderService.selectAllByOrder(orderQuery);
			request.getSession().setAttribute("orderQuery", orderQuery);
			
		}else{
			if(pageNum!=null)
			{
				//表示分页
				pageInfo = orderService.selectAllByOrder(pageNum, param);
				
			}else{
				if(orderQuery.getDelivery()!=null)
				{
					//表示点击
					param.setDelivery(orderQuery.getDelivery());
					pageInfo = orderService.selectAllByOrder(param);
					
				}else{
					param.setMenuName(orderQuery.getMenuName());
					param.setTimes(orderQuery.getTimes());
					pageInfo = orderService.selectAllByOrder(param);;
					//表示查询
				}
				request.getSession().setAttribute("orderQuery", param);
			}
		}
		return new ModelAndView("qiantai/order","pageInfo",pageInfo);
	}
}
