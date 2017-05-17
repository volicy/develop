package com.boot.test.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@EnableAutoConfiguration
public class Application {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	public String home() {
		logger.debug("hello");
		return "Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}