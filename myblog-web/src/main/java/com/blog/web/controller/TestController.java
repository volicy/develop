package com.blog.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.service.IUsersService;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	private IUsersService userService;
	
	@RequestMapping(value="/test1")
	@ResponseBody
	public String test1(HttpServletResponse response,HttpServletRequest reqeust){
		userService.insertUser(null);
		return "test";
	}
	
	
	@RequestMapping(value="/test")
	public String test(HttpServletResponse response,HttpServletRequest reqeust){
		
		return "test";
	}
	
	@RequestMapping(value="/test2")
	public String test2(HttpServletResponse response,HttpServletRequest reqeust){
		
		return "test2";
	}
}
