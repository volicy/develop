package com.test.springboot.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.test.springboot.dao.UsersDao;
import com.test.springboot.entity.Users;
import com.test.springboot.mapper.UsersMapper;


@Component
public class UsersDaoImpl implements UsersDao{

	
	@Resource
	private UsersMapper usersMapper;
	
	
	public Users getUsers(String username, String password) {
		Users user=new Users();
		user.setLoginName(username);
		user.setPassword(password);
		return usersMapper.getUsers(user);
	}
	@Cacheable(value="user",key="'username'+#username")  
	public Users getUsers2(String username, String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		return usersMapper.getUsers2(map);
	}

}
