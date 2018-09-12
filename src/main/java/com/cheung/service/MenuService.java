package com.cheung.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheung.dao.MenuMapper;
import com.cheung.dao.TypeMapper;
import com.cheung.pojo.Menu;
import com.cheung.pojo.MenuExample;
import com.cheung.pojo.Money;
import com.cheung.pojo.Type;
import com.cheung.pojo.TypeExample;
import com.cheung.utils.CommonsUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private TypeMapper typeMapper;
	
	/**
	 * 分页查询
	 * 默认页（第一页，十条数据）
	 * @return
	 */
	public PageInfo<Menu> selectList()
	{
		return selectList(1,6);
	}
	
	/**
	 * 分页查询
	 * 默认十条，输入第几页
	 * @param page
	 * @return
	 */
	public PageInfo<Menu> selectList(int page)
	{
		return selectList(page,6);
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param num
	 * @return
	 */
	public PageInfo<Menu> selectList(int page,int num)
	{
		PageHelper.startPage(page, num);
		List<Menu> menuList = menuMapper.selectAndType(new MenuExample());
		
		return new PageInfo<Menu>(menuList);
	}
	
	/**
	 * 根据id查询Menu
	 * @param id
	 * @return
	 */
	public Menu selectOneById(Integer id)
	{
		if(id==null)
		{
			throw new RuntimeException("id不能为空");
		}
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andIdEqualTo(id);
		List<Menu> menuList = menuMapper.selectByExample(menuExample);
		if(menuList!=null&& menuList.size()==1)
		{
			Menu menu = menuList.get(0);
			//查出type
			TypeExample example = new TypeExample();
			if(menu.getTypeid()!=null)
			{
				example.createCriteria().andIdEqualTo(Integer.parseInt(menu.getTypeid()));
			}
			List<Type> typeList = typeMapper.selectByExample(example);
			if(typeList!=null&&typeList.size()==1)
			{
				menu.setType(typeList.get(0));
			}
			return menu;
		}else{
			throw new RuntimeException("查询出错");
		}
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteOneById(Integer id)
	{
		if(id==null||id==0)
		{
			throw new RuntimeException("id有误");
		}
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andIdEqualTo(id);
		Integer num = menuMapper.deleteByExample(menuExample);
		if(num==null||num!=1)
		{
			throw new RuntimeException("删除menu过程出错");
		}
	}
	
	/**
	 * 根据id修改
	 * @param menu
	 */
	public void updateById(Menu menu)
	{
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andIdEqualTo(menu.getId());
		menuMapper.updateByExample(menu, menuExample);
	}
	
	/**
	 * 插入
	 * @param menu
	 */
	public void insert(Menu menu)
	{
		menuMapper.insertSelective(menu);
	}
	
	/**
	 * 通过name进行查找
	 * 
	 * @param name
	 * @return
	 */
	public Menu selectByName(String name)
	{
		Menu menu = null;
		try{
			menu = menuMapper.selectByPrimaryKey(name);
			return menu;
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * money
	 * @param req
	 * @param pageNum
	 * @param num
	 * @return
	 */
	public PageInfo<Money> todayMenu(HttpServletRequest req, Integer pageNum, Integer num)
	{
		List<Money> moneys = menuMapper.todayMenu("2015%");
		double dayMoney = 0;
		for(Money money : moneys)
		{
			if(money.isType())
			{
				dayMoney += money.getPrice1()*money.getNum();
				money.setSum(money.getPrice1()*money.getNum());
			}else{
				dayMoney += money.getPrice()*money.getNum();
				money.setSum(money.getPrice()*money.getNum());
			}
		}
		req.getSession().setAttribute("dayMoney", dayMoney);
		//真正查询
		PageHelper.startPage(pageNum, num);
		String now = CommonsUtils.getNowDay();
		//此处为now,测试用了2015
		List<Money> moneyList = menuMapper.todayMenu(now+"%");
		for(Money money : moneyList)
		{
			if(money.isType())
			{
				money.setSum(money.getPrice1()*money.getNum());
			}else{
				money.setSum(money.getPrice()*money.getNum());
			}
		}
		
		return new PageInfo<>(moneyList);
	}
	public PageInfo<Money> todayMenu(HttpServletRequest req, Integer pageNum)
	{
		return todayMenu(req, pageNum, 3);
	}
	public PageInfo<Money> todayMenu(HttpServletRequest req)
	{
		return todayMenu(req, 1, 3);
	}
	
	/**
	 * 排序条件String
	 * 取的条数
	 */
	public List<Menu> selectMax(Integer pageSize)
	{
		PageHelper.startPage(1, pageSize);
		return menuMapper.selectMax();
	}
}
