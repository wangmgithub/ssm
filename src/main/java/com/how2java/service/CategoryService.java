package com.how2java.service;

import java.util.ArrayList;
import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

public interface CategoryService {

	List<Category> list();
	Category login(Category category);
	int add(Category category);
	Category find(int id);
	public ArrayList<Category>selectSelective(Category category);
    //public Category getCategoryByName(String name);
	int update(Category category);
	public void delete(int id);
	//public int total();
	//List<Category> list(Page page);
	//事务
	void addTwo();
	void deleteAll();

}
