package com.mong.jdf.admin.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mong.jdf.admin.dao.StudentMapper;
import com.mong.jdf.admin.model.StudentEntity;

@Controller
public class TestController {

	@Autowired
	private StudentMapper studentMapper;

	@RequestMapping(value = "index.action")
	public void indexPage() {
		StudentEntity entity = studentMapper.getStudent("10000013");
		System.out.println("name：" + entity.getStudentName());
		System.out.println("123");
	}
	
	
	@RequestMapping(value = "login.action")
	public ModelAndView login(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		Subject subject=SecurityUtils.getSubject();
       
        
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
        UsernamePasswordToken token=new UsernamePasswordToken();
        
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        try{
            subject.login(token);
        }
        catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();
        } 
        catch (LockedAccountException lae) {
            lae.printStackTrace();
        }
        catch (AuthenticationException ae) {
            ae.printStackTrace();
        } 
        catch(Exception e){
            e.printStackTrace();
            System.out.println("123");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        //登陆成功，跳转主界面
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        System.out.println("success");
        return new ModelAndView("admin/index", null);
	}
}
