/* 
 * @(#)UserController.java    Created on 2014-7-29
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mong.jdf.admin.dao.UserDao;
import com.mong.jdf.admin.model.User;
import com.mong.jdf.controller.BaseController;

@Controller
@RequestMapping("/user/*")
public class UserController extends BaseController{

    @Autowired
    private UserDao userDao;
    
    @ResponseBody
    @RequestMapping(value = "list")
    public String list(){
        List<User> list = userDao.listAll();
        return marshal(list);
    }
}
