package com.test.springboot.dao;

import com.test.springboot.entity.Users;

public interface UsersDao {

	Users getUsers(String username,String password);
	
	Users getUsers2(String username,String password);
}
