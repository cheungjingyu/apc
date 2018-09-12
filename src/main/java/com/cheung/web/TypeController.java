package com.cheung.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Type;
import com.cheung.service.TypeService;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.CommonsUtils;

@Controller
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list.do")
	public ModelAndView typeList()
	{
		ModelAndView modelAndView = new ModelAndView("admin/type");
		List<Type> typeList = typeService.selectAll();
		modelAndView.addObject("typeList", typeList);
		return modelAndView;
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/add.do")
	public ModelAndView typeAddPage()
	{
		return new ModelAndView("admin/type_add");
	}
	
	/**
	 * 添加按钮
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public @ResponseBody AjaxResult addSubmit(Type type)
	{
		/*
		 *type正确性 
		 */
		if(type==null)
		{
			return AjaxResult.errorInstance("添加失败");
		}
		if(CommonsUtils.isEmpty(type.getName()))
		{
			return AjaxResult.errorInstance("类型不能为空");
		}
		/*
		 * 重复性检查
		 */
		Type param = typeService.selectOneByName(type.getName());
		if(param!=null)
		{
			return AjaxResult.errorInstance("类型名称重复");
		}
		
		try{
			typeService.insert(type);
		}catch(Exception e)
		{
			return AjaxResult.errorInstance("添加失败：服务器出错");
		}
		return AjaxResult.successInstance("添加成功");
	}
	
	
	
	/**
	 * 打开修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/update.do")
	public ModelAndView typeUpdate(Integer id)
	{
		if(id==null)
		{
			return new ModelAndView("500","message","修改失败");
		}
		Type type = null;
		try{
			type = typeService.selectOneById(id);
		}catch(Exception e)
		{
			return new ModelAndView("500","message","修改失败：服务器出错");
		}
		return new ModelAndView("/admin/type_update","type",type);
	}
	
	/**
	 * 修改按钮
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public @ResponseBody AjaxResult updateSubmit(Type type)
	{
		if(type==null)
		{
			return AjaxResult.errorInstance("修改失败");
		}
		if(CommonsUtils.isEmpty(type.getName()))
		{
			return AjaxResult.errorInstance("类型不能为空");
		}
		Type param = typeService.selectOneByName(type.getName());
		
		if(param!=null&&param.getId()!=type.getId())
		{
			return AjaxResult.errorInstance("类型名称重复");
		}
		try{
			typeService.update(type);
		}catch(Exception e)
		{
			return AjaxResult.errorInstance("修改失败：服务器出错");
		}
		return AjaxResult.successInstance("修改成功");
	}
	
	/**
	 * delete
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete.do")
	public @ResponseBody AjaxResult typeDelete(Integer id)
	{
		if(id==null)
		{
			return AjaxResult.errorInstance("删除失败:id为空");
		}
		try{
			typeService.deleteById(id);
		}catch(Exception e)
		{
			AjaxResult.errorInstance("删除失败：服务器出错");
		}
		return AjaxResult.successInstance("删除成功");
	}
}
