package com.how2java.mapper;
 
import java.util.ArrayList;
import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

public interface CategoryMapper {
 
      
    public int add(Category category);  
       
      
    public void delete(int id);  
       
      
    public Category find(int id);  
     
      
    public int update(Category category);   
       
      
    public List<Category> list();
    
      
    public int count(); 
    
    public Category login(Category category);
    
    public ArrayList<Category>selectSelective(Category category);
    
    //public Category getCategoryByName(String name);
   // public int total();
    //List<Category> list(Page page);
}