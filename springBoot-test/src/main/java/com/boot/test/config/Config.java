package com.boot.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class Config {


	@Value("${jdbc_key}")
	private String jdbc_key;

	public String getJdbc_key() {
		return jdbc_key;
	}

	public void setJdbc_key(String jdbc_key) {
		this.jdbc_key = jdbc_key;
	}
	
	
	
}
