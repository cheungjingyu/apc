package com.cheung.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Menu;
import com.cheung.service.MenuService;

@Controller
@RequestMapping("/qtmenu")
public class QTMenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/show.do")
	public ModelAndView show(Integer id)
	{
		Menu menu = menuService.selectOneById(id);
		return new ModelAndView("qiantai/show","menu",menu);
	}
}
