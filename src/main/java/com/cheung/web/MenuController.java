package com.cheung.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Menu;
import com.cheung.pojo.Money;
import com.cheung.pojo.Type;
import com.cheung.service.MenuService;
import com.cheung.service.TypeService;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.CommonsUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private TypeService typeService;
	
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/add.do")
	public ModelAndView menuAddPage()
	{
		ModelAndView modelAndView = new ModelAndView("admin/menus_add");
		List<Type> typeList = typeService.selectAll();
		modelAndView.addObject("typeList", typeList);
		return modelAndView;
	}
	
	/**
	 * 添加按钮
	 * @param request
	 * @param part
	 * @param menu
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public ModelAndView menuAddSubmit(MultipartFile part, HttpServletRequest request, Menu menu) throws IllegalStateException, IOException
	{
		/**
		 * 先判断图片格式是否正确
		 * 菜名是否为空
		 * 判断菜名是否存在
		 * 保存menu
		 * 保存图片
		 */
		String imgType = part.getContentType();//图片类型
		if(!(imgType.equalsIgnoreCase("image/png")||imgType.equalsIgnoreCase("image/jpg")||imgType.equalsIgnoreCase("image/jpeg")||imgType.equalsIgnoreCase("image/gif")))
		{
			return new ModelAndView("admin/menus_add","message","图片格式只能为png,jpg,jpeg,gif");
		}
		if(CommonsUtils.isEmpty(menu.getName()))
		{
			return new ModelAndView("admin/menus_add","message","菜名不能为空");
		}
		
		Menu param = menuService.selectByName(menu.getName());
		if(param!=null)
		{
			return new ModelAndView("admin/menus_add","message","菜名已存在");
		}
		String savePath = request.getServletContext().getRealPath("/img");
		String fileName = UUID.randomUUID().toString() + part.getOriginalFilename();
		File file = new File(savePath + "/" + fileName);
		menu.setImgpath("img/"+fileName);
		try{
			menuService.insert(menu);
		}catch(Exception e)
		{
			return new ModelAndView("admin/menus_add","message","添加失败");
		}
		//保证数据插入成功后再进行图片保存
		part.transferTo(file);
		return new ModelAndView("redirect:/menu/list.do");
	}
	
	/**
	 * 修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/update.do")
	public ModelAndView menuUpdatePage(Integer id)
	{
		ModelAndView modelAndView = new ModelAndView("admin/menus_update");
		//menu
		Menu menu = menuService.selectOneById(id);
		modelAndView.addObject("menu", menu);
		
		//typeList
		List<Type> typeList = typeService.selectAll();
		modelAndView.addObject("typeList", typeList);
		return modelAndView;
	}
	
	/**
	 * 修改按钮
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public @ResponseBody AjaxResult menuUpdateSubmit(Menu menu)
	{
		if(CommonsUtils.isEmpty(menu.getName()))
		{
			return AjaxResult.errorInstance("菜名不能为空");
		}
		Menu param = menuService.selectByName(menu.getName());
		if(param!=null&&param.getId()!=menu.getId())
		{
			return AjaxResult.errorInstance("菜名已存在");
		}
		try{
			param = menuService.selectOneById(menu.getId());
			param.setName(menu.getName());
			param.setBurden(menu.getBurden());
			param.setPrice(menu.getPrice());
			param.setPrice1(menu.getPrice1());
			param.setBrief(menu.getBrief());
			param.setTypeid(menu.getTypeid());
			menuService.updateById(param);
		}catch(Exception e)
		{
			return AjaxResult.errorInstance("服务器出错，修改失败");
		}
		return AjaxResult.successInstance("修改成功");
	}
	
	/**
	 * 列表，自动分页
	 * @return
	 */
	@RequestMapping("/list.do")
	public ModelAndView menuList(Integer pageNum)
	{
		
		ModelAndView modelAndView = new ModelAndView("admin/menus");
		PageInfo<Menu> pageInfo = null;
		if(pageNum==null)
		{
			pageInfo =  menuService.selectList();
		}else{
			pageInfo =  menuService.selectList(pageNum);
		}
		
		modelAndView.addObject("pageInfo", pageInfo);
		
		return modelAndView;
	}
	
	@RequestMapping("/delete.do")
	public @ResponseBody AjaxResult menuDelete(Integer id)
	{
		try{
			menuService.deleteOneById(id);
		}catch(Exception e)
		{
			return AjaxResult.errorInstance("删除失败");
		}
		return AjaxResult.successInstance("删除成功");
		
	}
	
	@RequestMapping("/statistic.do")
	public ModelAndView todayMenu(HttpServletRequest req, Integer pageNum)
	{
		ModelAndView modelAndView = new ModelAndView("admin/order_statistic");
		PageInfo<Money> pageInfo = null;
		if(pageNum==null)
		{
			pageInfo =  menuService.todayMenu(req);
		}else{
			pageInfo =  menuService.todayMenu(req, pageNum);
		}
		modelAndView.addObject("pageInfo", pageInfo);
		
		return modelAndView;
	}
	
	
	
}
