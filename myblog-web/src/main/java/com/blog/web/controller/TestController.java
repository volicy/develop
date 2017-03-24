package com.blog.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {

	
	@RequestMapping(value="/test1")
	public String test(HttpServletResponse response,HttpServletRequest reqeust){
		
		return "test";
	}
}
