package com.cheung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheung.dao.UserMapper;
import com.cheung.pojo.User;
import com.cheung.pojo.UserExample;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * login
	 * @param user
	 * @return
	 */
	public User login(User user)
	{
		//先根据用户名查出，再进行密码的比对，（密码盐考虑）
		User param = userMapper.selectByPrimaryKey(user.getName());
		if(param!=null && param.getPwd().equals(user.getPwd()))
		{
			return param;
		}
		return null;
	}
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public User selectOneById(Integer id)
	{
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(id);
		List<User> userList = userMapper.selectByExample(example);
		if(userList==null||userList.size()==0)
		{
			return null;
		}
		return userList.get(0);
	}
	
	public void insert(User user)
	{
		userMapper.insert(user);
	}
	public User selectOneByName(String name)
	{
		return userMapper.selectByPrimaryKey(name);
	}

	public void update(User user) 
	{
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		userMapper.updateByExampleSelective(user, example);
	}
}
