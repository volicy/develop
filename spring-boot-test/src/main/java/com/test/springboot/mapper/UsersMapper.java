package com.test.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.test.springboot.entity.Users;

public interface UsersMapper{

	Users getUsers(Users user);

	Users getUsers2(Map<String, Object> map);
	
	List<Users> findAll();

	int insertA(Users user);
	int updateA(Users user);
	Users findById(Integer id);
}











