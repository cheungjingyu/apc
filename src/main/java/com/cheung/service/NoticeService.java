package com.cheung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheung.dao.NoticeMapper;
import com.cheung.pojo.Notice;
import com.cheung.pojo.NoticeExample;
import com.github.pagehelper.PageHelper;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	/**
	 * 查询所有，并根据事件降序排序
	 * @return
	 */
	public List<Notice> selectAll()
	{
		NoticeExample example = new NoticeExample();
		example.setOrderByClause("times desc");
		List<Notice> noticeList = noticeMapper.selectByExample(example);
		return noticeList;
	}
	public List<Notice> selectSix()
	{
		PageHelper.startPage(1, 6);
		PageHelper.orderBy("times desc");
		NoticeExample example = new NoticeExample();
		example.setOrderByClause("times desc");
		List<Notice> noticeList = noticeMapper.selectByExample(example);
		return noticeList;
	}
	
	/**
	 * insert
	 * @param notice
	 */
	public void insert(Notice notice)
	{
		noticeMapper.insert(notice);
	}
	
	/**
	 * delete
	 * @param id
	 */
	public void delete(Integer id)
	{
		NoticeExample example = new NoticeExample();
		example.createCriteria().andIdEqualTo(id);
		noticeMapper.deleteByExample(example);
	}
	
	/**
	 * get one by id
	 * @return
	 */
	public Notice selectOneById(Integer id)
	{
		NoticeExample example = new NoticeExample();
		example.createCriteria().andIdEqualTo(id);
		List<Notice> noticeList = noticeMapper.selectByExample(example);
		if(noticeList==null||noticeList.size()==0)
		{
			return null;
		}
		return noticeList.get(0);
	}
}
