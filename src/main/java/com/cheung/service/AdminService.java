package com.cheung.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheung.dao.AdminMapper;
import com.cheung.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	/**
	 * 用于登陆查询。查询成功，返回查到的对象。查询失败返回null
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin)
	{
		//先根据用户名查出，再进行密码的比对，（密码盐考虑）
		Admin param = adminMapper.selectByPrimaryKey(admin.getName());
		if(param!=null && param.getPwd().equals(admin.getPwd()))
		{
			return param;
		}
		return null;
	}
	/**
	 * 根据id查询出用户
	 * @param id
	 * @return
	 */
	public Admin getOne(int id)
	{
		return adminMapper.getOne(id);
	}
	
	public void updatePwd(Admin admin)
	{
		adminMapper.updateByPrimaryKeySelective(admin);
		
	}
}
