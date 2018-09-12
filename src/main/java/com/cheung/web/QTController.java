package com.cheung.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Menu;
import com.cheung.pojo.Notice;
import com.cheung.service.MenuService;
import com.cheung.service.NoticeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/qiantai")
public class QTController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/")
	public ModelAndView no()
	{
		return new ModelAndView("redirect:/qiantai/index.do");
	}
	
	@RequestMapping("/index.do")
	public ModelAndView index(Integer pageNum)
	{
		ModelAndView modelAndView = new ModelAndView("qiantai/index");
		/*
		 * 1.menu实现分页查询
		 */
		PageInfo<Menu> pageInfo = null;
		if(pageNum==null)
		{
			pageInfo = menuService.selectList();
			
		}else{
			pageInfo = menuService.selectList(pageNum);
		}
		modelAndView.addObject("pageInfo",pageInfo);
		/*
		 * 实现页面获取前六条
		 */
		List<Notice> noticeList = noticeService.selectSix();
		modelAndView.addObject("noticeList", noticeList);
		/*
		 * 销售排行
		 */
		List<Menu> menuList = menuService.selectMax(6);
		modelAndView.addObject("menuList", menuList);
		return modelAndView;
	}
	
	
	
	/**
	 *  配送说明
	 * @return
	 */
	@RequestMapping("/carry.do")
	public ModelAndView carry()
	{
		return new ModelAndView("qiantai/carry");
	}
	
	/**
	 * 关于我们
	 * @return
	 */
	@RequestMapping("/our.do")
	public ModelAndView our()
	{
		return new ModelAndView("qiantai/our");
	}
}
