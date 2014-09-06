/* 
 * @(#)UserController.java    Created on 2014-7-29
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mong.jdf.admin.dao.UserDao;
import com.mong.jdf.admin.model.User;
import com.mong.jdf.controller.BaseController;
import com.mong.jdf.utils.DataResponse;

@Controller
@RequestMapping("/user/**")
public class UserController extends BaseController{

    @Autowired
    private UserDao userDao;
    
    @ResponseBody
    @RequestMapping(value = "list")
    public String list(
    		@RequestParam(value="username", required=false)String username){
    	System.out.println(username);
        DataResponse dataResponse = new DataResponse();
        List<User> list = userDao.listAll();
        dataResponse.setSuccess(true);
        dataResponse.setData(list);
        return marshal(dataResponse);
    }
    
    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        try{
            subject.login(token);
            return new ModelAndView("redirect:/index.jsp");
        }
        catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();
        } 
        catch (LockedAccountException lae) {
            lae.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        //登陆成功，跳转主界面
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return new ModelAndView("redirect:/login.jsp");
    }
}
