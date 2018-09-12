package com.cheung.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheung.pojo.Notice;
import com.cheung.service.NoticeService;

@Controller
@RequestMapping("/qtnotice")
public class QTNoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("show.do")
	public ModelAndView show(Integer id)
	{
		Notice notice = noticeService.selectOneById(id);
		return new ModelAndView("qiantai/notice","notice",notice);
	}
}
