/* 
 * @(#)UserDao.java    Created on 2014-7-25
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.admin.dao;

import java.util.List;

import com.mong.jdf.admin.model.User;
import com.mong.jdf.dao.BaseDao;

public interface UserDao extends BaseDao{

    User getUser(String string);

    List<User> listAll();

}
