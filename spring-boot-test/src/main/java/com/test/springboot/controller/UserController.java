package com.test.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.test.springboot.entity.Users;
import com.test.springboot.service.UsersService;


@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/getUser")
	@ResponseBody
	public String selectUser(HttpServletRequest request,HttpServletResponse response){
		Users user=usersService.getUsers("13391700144", "0ab44bd43d6b18fcd5cd928d6faab1b8");
		if(user!=null){
			System.out.println("1111111:"+JSON.toJSON(user));
		}
		return JSON.toJSON(user).toString();
	}
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request,HttpServletResponse response){
		return "test";
	}
	
}
