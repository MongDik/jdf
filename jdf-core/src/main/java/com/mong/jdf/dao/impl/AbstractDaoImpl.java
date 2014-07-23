/* 
 * @(#)AbstractDaoImpl.java    Created on 2014-7-21
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.mong.jdf.dao.BaseDao;

public class AbstractDaoImpl extends SqlSessionDaoSupport implements BaseDao{

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
