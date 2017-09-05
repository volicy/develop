package com.test.springboot.service;

import com.test.springboot.entity.Users;

public interface UsersService {

	Users getUsers(String username,String password);
}
