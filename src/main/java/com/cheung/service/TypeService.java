package com.cheung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheung.dao.TypeMapper;
import com.cheung.pojo.Type;
import com.cheung.pojo.TypeExample;

@Service
public class TypeService {

	@Autowired
	private TypeMapper mapper;
	
	/**
	 * 获取所有
	 * @return
	 */
	public List<Type> selectAll()
	{
		return mapper.selectByExample(new TypeExample());
	}
	
	public Type selectOneById(Integer id)
	{
		if(id==null)
		{
			throw new RuntimeException("id不能为空");
		}
		TypeExample example = new TypeExample();
		example.createCriteria().andIdEqualTo(id);
		List<Type> typeList = mapper.selectByExample(example);
		if(typeList==null||typeList.size()==0)
		{
			return null;
		}
		if(typeList.size()!=1)
		{
			throw new RuntimeException("查询出多个");
		}
		return typeList.get(0);
		
	}
	
	
	/**
	 * 据id删除
	 * @param id
	 */
	public void deleteById(Integer id)
	{
		TypeExample example = new TypeExample();
		example.createCriteria().andIdEqualTo(id);
		mapper.deleteByExample(example);
	}
	
	/**
	 * insert
	 * @param type
	 */
	public void insert(Type type)
	{
		mapper.insertSelective(type);
	}
	
	/**
	 * update
	 * @param type
	 */
	public void update(Type type)
	{
		TypeExample example = new TypeExample();
		example.createCriteria().andIdEqualTo(type.getId());
		mapper.updateByExample(type, example);
	}
	
	/**
	 * select one by name
	 * @param name
	 * @return
	 */
	public Type selectOneByName(String name)
	{
		Type type = null;
		try {
			type = mapper.selectByPrimaryKey(name);
			return type;
		} catch (Exception e) {
			return null;
		}
	}
}
