/* 
 * @(#)UserDaoImpl.java    Created on 2014-7-25
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mong.jdf.admin.dao.UserDao;
import com.mong.jdf.admin.mapper.UserMapper;
import com.mong.jdf.admin.model.User;
import com.mong.jdf.dao.impl.BaseDaoImpl;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	@Autowired
	private UserMapper userMapper;
	
    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listUser();
    }

}
