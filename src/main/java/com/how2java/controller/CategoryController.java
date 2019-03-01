package com.how2java.controller;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.json.JsonObject;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.util.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;

// 告诉spring mvc这是一个控制器类

@Controller
@RequestMapping("/user")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //PageHelper分页效果
    @RequestMapping("/listCategory")
    public ModelAndView listCategory(Page page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),5);
        List<Category>cs=categoryService.list();
        int total= (int) new PageInfo<>(cs).getTotal();
        page.cacuLast(total);
        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("jsp/listCategory");
        return mav;
    }

    /*    //传统分页
    @RequestMapping("/listCategory")
    public ModelAndView listCategory(Page page){
        ModelAndView mav = new ModelAndView();
        List<Category> cs= categoryService.list(page);
        for (Category c:cs
             ) {
            System.out.println(c);
        }
        int total=categoryService.total();//总个数
        page.cacuLast(total);
        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("jsp/listCategory");
        return mav;
    }
    */

    /**
     * 登录页面生成验证码
     */
//    @RequestMapping(value = "/getVerify")
//    public void getVerify(HttpServletRequest request, HttpServletResponse response){
//        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
//        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expire", 0);
//        RandomValidateCode randomValidateCode = new RandomValidateCode();
//        try {
//            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    //放sesseion里面
    @RequestMapping("/login")
    public String login(HttpSession  session,Category category,String inputStr,HttpServletRequest request,Model  model){
        System.out.println("name:"+category.getName());
        //String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");

        List<Category>list=new ArrayList<Category>();
        Category category2=new Category();

        list=categoryService.selectSelective(category);
        //Category a=categoryService.login(category);

//		System.out.println("a:"+list);
//		 try {
//	            if(random.equals(inputStr)){
//
//
//	                return  "user/login" ;
//	            }else {
//	                model.addAttribute("error","验证码错误");
//	                return "redirect:/";
//	            }
//
//	        } catch (AuthenticationException e) {
//	            e.printStackTrace();
//	            model.addAttribute("error","用户名或密码错误");
//	            return "redirect:/";
//	        }
//	}
//   if(random.equals(inputStr)){//验证码正确
//	   if (list.size()==0){
//			model.addAttribute("result","0");//密码账户有误
//		}else{
//			category2.setPassword(category.getPassword());
//			category2.setName(category.getName());
//			System.out.println("name:"+category2.getName()+"password:"+category2.getPassword());
//			list=categoryService.selectSelective(category2);
//		if(list.size()==0){
//		model.addAttribute("result","1");//密码错误
//		}else{
//			model.addAttribute("result","2");//登录成功
//		}
//   }
//
//   }else{
//	   model.addAttribute("result","3");
//   }

        ////////////////////////////////////////////
        if (list.size()==0){
            model.addAttribute("result","0");//密码账户有误
        }else{
            category2.setPassword(category.getPassword());
            category2.setName(category.getName());
            System.out.println("name:"+category2.getName()+"password:"+category2.getPassword());
            list=categoryService.selectSelective(category2);
            if(list.size()==0){
                model.addAttribute("result","1");//密码错误
            }else{
                category=list.get(0);
                //将用户保存在session里面
                model.addAttribute("result","2");//登录成功
            }
        }
        return"index";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute Category category,HttpServletRequest request,Model model,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
        System.out.println("name:"+category.getName());
        System.out.println("password:"+category.getPassword());
        //上传图片

        //保存数据路径
        String sqlpath=null;
        //定义文件保存的本地路径
        String localpath="D:\\File\\";
        //定义 文件名
        String filename=null;
        if(!category.getFile().isEmpty()){
            //生成uuid作为文件名称
            String uuid=UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型(可以判断如果不是图片,禁止上传)
            String contentType=category.getFile().getContentType();
            //获取文件后缀
            String suffixname=contentType.substring(contentType.indexOf("/")+1);
            //得到文件名
            filename=uuid+"."+suffixname;
            System.out.println("filename:"+filename);
            //文件保存 路径
            category.getFile().transferTo(new File(localpath+filename));
        }
        // 把图片的相对路径保存到数据库
        sqlpath="D:/File/images/"+filename;
        System.out.println("sqlpath:"+sqlpath);
        category.setImage(sqlpath);

        //上传文件

//        String pathfile="d:\\upload\\";//上传保存路径
//
//        file.transferTo(new File(pathfile+file.getOriginalFilename()));


        List<Category> list=categoryService.selectSelective(category);
        if(list.size()==0){
            int addstr =categoryService.add(category);
            if(addstr>0)
                model.addAttribute("result", "1");
            else
                model.addAttribute("result", "0");
        }else
            model.addAttribute("result", "2");
        return"jsp/regist";
    }

    @RequestMapping("/find")
    public String find(int id,HttpServletRequest request,Model model){
        ModelAndView mav = new ModelAndView();
        System.out.println("id:"+id);
        Category cs =categoryService.find(id);
        if(cs!=null){
            // 放入转发参数
            //mav.addObject("cs", cs);
            model.addAttribute("cs", cs);
            return "jsp/findid";
        }
        return "jsp/find";
    }

    @RequestMapping("/edit")
    public String edit(int id,Category category,HttpServletRequest request,Model model){
        System.out.println("id:"+id);
        category=categoryService.find(id);
        System.out.println("name:"+category.getName());
        model.addAttribute("cs", category);
        return "jsp/edit";
    }

    @RequestMapping("/update")
    public  String update(@ModelAttribute Category category,int id,Model model){
        //int b=id;
        System.out.println("id-------:"+id);
        System.out.println("id:"+category.getId()+"name:"+category.getName()+"passord:"+category.getPassword());

        int a=categoryService.update(category);
        if(a>0){
            model.addAttribute("result","0");//修改成功
            return "redirect:/user/listCategory";//重定向
        }
        model.addAttribute("result","1");//修改失败
        return "redirect:/user/edit?id="+category.getId();//重定向传参
    }

    @RequestMapping("/delete")
    public String delete(int id,Model model){

        categoryService.delete(id);

        return "redirect:/user/listCategory";//重定向
    }

    @RequestMapping("/peopleSelect")
    @ResponseBody
    public Category peopleSelect(@RequestBody Map<String,String> map) {
        //使用map.get方法得到JSON中id对应的值
        int id=Integer.parseInt(map.get("id"));
        //查找对应id的用户信息
        Category category = categoryService.find(id);
        //返回用户信息，要使用@ResponseBody将返回值转换为JSON
        return category;
    }
//upload 上传文件测试

@RequestMapping("/upload")
public String UploadData(String name,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
    System.out.println("1111111111111111111");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
    String res = sdf.format(new Date());

    // uploads文件夹位置
    String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");
    // 原始名称
    String originalFileName = file.getOriginalFilename();
    // 新文件名
    String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
    // 创建年月文件夹
    Calendar date = Calendar.getInstance();
    File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

    // 新文件
    File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
    // 判断目标文件所在目录是否存在
    if( !newFile.getParentFile().exists()) {
        // 如果目标文件所在的目录不存在，则创建父目录
        newFile.getParentFile().mkdirs();
    }
    System.out.println(newFile);
    // 将内存中的数据写入磁盘
    file.transferTo(newFile);
    // 完整的url
    String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
    System.out.println(fileUrl);
    return  "jsp/uploadsuccess";
}
    //json测试


/*
    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory(){
    Category c=new Category();
    c.setId(100);
    c.setName("第100个分类");
        JSONObject json=new JSONObject();
        json.put("category", JSON.toJSON(c));
        return json.toJSONString();
    }
*/
}
