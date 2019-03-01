package com.how2java.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Mr.wang
 * @date:2019/2/28 0028 上午 11:59
*/
@Controller
@RequestMapping("")
public class ControllerJsonTest {
    @Autowired
    private CategoryService categoryService;
    //json测试
    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category, Model model) {
        System.out.println("+++++++"+category.getName());
        String msg;
        int a=categoryService.add(category);
        if(a>0){
           // model.addAttribute("result","添加成功！");
             msg="添加成功!";
        }else{
          //  model.addAttribute("result","添加失败！");
            msg="添加失败!";
        }
        JSONObject j=new JSONObject();
        j.put("msg",JSON.toJSON(msg));
        return j.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory(){
        Category c=new Category();
        c.setId(1000);
        c.setName("第10000个分类");
        JSONObject json=new JSONObject();
        json.put("category", JSON.toJSON(c));
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        //传json值到页面var last=obj.toJSONString(); //将JSON对象转化为JSON字符
        //2.使用stringify
        //
        //    [javascript] view plain copy
        //    var last=JSON.stringify(obj); //将JSON对象转化为JSON字符
        List<Category> cs=categoryService.list();
       JSONObject jsonObject=new JSONObject();
       jsonObject.put("category",cs) ;
       return jsonObject.toJSONString();//将JSON对象转化为JSON字符
    }
}
