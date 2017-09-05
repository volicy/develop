package com.test.springboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.springboot.dao.UsersDao;
import com.test.springboot.entity.Users;
import com.test.springboot.service.UsersService;


@Service
public class UsersServiceImpl implements UsersService{

	@Resource
	private UsersDao userDao;
	
	public Users getUsers(String username, String password) {
		return userDao.getUsers2(username, password);
	}

}
