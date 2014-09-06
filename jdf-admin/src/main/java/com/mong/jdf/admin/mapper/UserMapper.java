package com.mong.jdf.admin.mapper;

import java.util.List;

import com.mong.jdf.admin.model.User;

public interface UserMapper {

	User getUser(String username);
	
	List<User> listUser();
}
