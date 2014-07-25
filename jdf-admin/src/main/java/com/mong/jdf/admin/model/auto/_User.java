/* 
 * @(#)_User.java    Created on 2014-7-25
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.admin.model.auto;

import com.mong.jdf.entity.BaseEntity;

public class _User extends BaseEntity{

    private Integer id;
    private String username;
    private String fullname;
    private String password;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void serUsername(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
