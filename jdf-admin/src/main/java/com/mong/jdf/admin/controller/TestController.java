package com.mong.jdf.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mong.jdf.admin.dao.UserDao;
import com.mong.jdf.admin.model.User;
import com.mong.jdf.controller.BaseController;

@Controller
@RequestMapping("/test/*")
public class TestController extends BaseController{

	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "index")
	public ModelAndView index(){
	    User user = userDao.getUser("test");
	    ModelMap model = new ModelMap();
	    model.addAttribute("user", user);
	    return new ModelAndView("admin/index", model);
	}
	
	@ResponseBody
	@RequestMapping(value = "test")
    public String test(){
	    return "test";
    }

//	@RequestMapping(value = "index.action")
//	public void indexPage() {
//		Student entity = studentMapper.getStudent("10000013");
//		System.out.println("name：" + entity.getStudentName());
//		System.out.println("123");
//	}
//	
//	
}
