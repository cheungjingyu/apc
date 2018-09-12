package com.cheung.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Notice;
import com.cheung.service.NoticeService;
import com.cheung.utils.AjaxResult;
import com.cheung.utils.CommonsUtils;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	/**
	 * list
	 * @return
	 */
	@RequestMapping("/list.do")
	public ModelAndView noticeList()
	{
		/*
		 * 查询列表内容，封装到model中 
		 */
		List<Notice> noticeList = noticeService.selectAll();
		return new ModelAndView("admin/notice","noticeList",noticeList);
	}
	
	/**
	 * addPage
	 * @return
	 */
	@RequestMapping("/add.do")
	public ModelAndView noticeAdd()
	{
		return new ModelAndView("admin/notice_add");
	}
	
	/**
	 * addSubmit
	 * @return
	 */
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public @ResponseBody AjaxResult noticeAddSubmit(Notice notice)
	{
		//正确性检查
		if(notice==null)
		{
			return AjaxResult.errorInstance("添加失败");
		}
		//有效性检查
		if(CommonsUtils.isEmpty(notice.getName()))
		{
			return AjaxResult.errorInstance("标题不能为空");
		}
		notice.setTimes(CommonsUtils.getNowTime());
		//插入
		try{
			noticeService.insert(notice);
		}catch(Exception e)
		{
			return AjaxResult.errorInstance("添加失败:服务器出错");
		}
		
		return AjaxResult.successInstance("添加成功");
	}
	
	/**
	 * delete
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete.do")
	public @ResponseBody AjaxResult noticeDelete(Integer id)
	{
		if(id==null)
		{
			return AjaxResult.errorInstance("删除失败");
		}
		try{
			noticeService.delete(id);
		}catch(Exception e)
		{
			return AjaxResult.errorInstance("删除失败:服务器出错");
		}
		return AjaxResult.successInstance("删除成功");
	}
	
}
