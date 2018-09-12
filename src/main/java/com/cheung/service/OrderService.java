package com.cheung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheung.dao.MenuMapper;
import com.cheung.dao.OrderMapper;
import com.cheung.pojo.Menu;
import com.cheung.pojo.Order;
import com.cheung.pojo.OrderExample;
import com.cheung.pojo.OrderExample.Criteria;
import com.cheung.pojo.OrderQuery;
import com.cheung.utils.CommonsUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	/**
	 * list
	 * @return
	 */
	public PageInfo<Order> selectAll()
	{
		return selectAll(1, 5);
	}
	public PageInfo<Order> selectAll(int pageNum)
	{
		return selectAll(pageNum, 5);
	}
	public PageInfo<Order> selectAll(int pageNum,int num)
	{
		PageHelper.startPage(pageNum, num);
		PageHelper.orderBy("delivery asc,times desc");
		OrderExample example = new OrderExample();
		List<Order> orderList = orderMapper.selectAll(example);
		return new PageInfo<>(orderList);
	}
	
	/**
	 * search
	 * @return
	 */
	public PageInfo<Order> selectAllByOrder(OrderQuery query)
	{
		return selectAllByOrder(1, 5, query);
	}
	public PageInfo<Order> selectAllByOrder(int pageNum, OrderQuery query)
	{
		return selectAllByOrder(pageNum, 5, query);
	}
	public PageInfo<Order> selectAllByOrder(int pageNum, int num, OrderQuery query)
	{
		
		//配置查询条件
				OrderExample example = new OrderExample();
				Criteria criteria = example.createCriteria();
		//先拿到Order中的menu
		if(!CommonsUtils.isEmpty(query.getMenuName()))
		{
			//这个地方可以like查询
			Menu menu = menuMapper.selectByPrimaryKey(query.getMenuName());
			if(menu!=null)
			{
				criteria.andMenuidEqualTo(menu.getId()+"");
			}
		}
		if(query.getUserId()!=null&&query.getUserId()!=0)
		{
			criteria.andUseridEqualTo(query.getUserId()+"");
		}
		if(!CommonsUtils.isEmpty(query.getTimes()))
		{
			criteria.andTimesLike(query.getTimes()+"%");
		}
		if(!CommonsUtils.isEmpty(query.getDelivery()))
		{
			criteria.andDeliveryEqualTo(query.getDelivery());
		}
		PageHelper.startPage(pageNum, num);
		PageHelper.orderBy("delivery asc,times desc");
		List<Order> orderList = orderMapper.selectAll(example);
		return new PageInfo<>(orderList);
	}
	
	/**
	 * 订单确认
	 * @param id
	 */
	public void orderY(Integer id)
	{
		Order order = new Order();
		order.setDelivery("1");
		OrderExample example = new OrderExample();
		example.createCriteria().andIdEqualTo(id);
		orderMapper.updateByExampleSelective(order, example);
	}
	
	/**
	 * 取消订单
	 * @param id
	 */
	public void orderN(Integer id)
	{
		OrderExample example = new OrderExample();
		example.createCriteria().andIdEqualTo(id);
		orderMapper.deleteByExample(example);
	}
	
	public void InsertAll(List<Order> orderList)
	{
		for(Order order : orderList)
		{
			orderMapper.insertSelective(order);
		}
	}
	
	
}
