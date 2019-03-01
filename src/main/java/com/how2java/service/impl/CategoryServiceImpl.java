package com.how2java.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.how2java.mapper.CategoryMapper;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.how2java.pojo.Category;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
	CategoryMapper categoryMapper;

	public List<Category> list(){
		return categoryMapper.list();
	}

	public Category login(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.login(category);
	}


	public int add(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.add(category);
	}


	public Category find(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.find(id);
	}


	public ArrayList<Category> selectSelective(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.selectSelective(category);
	}


	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.update(category);
	}


	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryMapper.delete(id);
	}

	@Override
	public void addTwo() {
		Category c1 = new Category();
		c1.setName("短的名字");
		categoryMapper.add(c1);

		Category c2 = new Category();
		c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
		categoryMapper.add(c2);
	}

	@Override
	public void deleteAll() {
	List<Category> cs=list();
		for (Category c:cs
			 ) {
			categoryMapper.delete(c.getId());
		}
	}
/*
	@Override
	public int total() {
		return categoryMapper.total();
	}

	@Override
	public List<Category> list(Page page) {
		return categoryMapper.list(page);
	}
*/

//
//	public Category getCategoryByName(String name) {
//		// TODO Auto-generated method stub
//		return categoryMapper.getCategoryByName(name);
//	};

}
