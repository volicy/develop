package com.blog.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.blog.core.entity.Users;
import com.blog.service.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService{

	@Override
	public void insertUser(List<Users> users) {
		System.out.println("insertUser start");
		
	}

}
