package com.boot.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {


	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.acquireIncrement}")
	private int acquireIncrement;
	
	@Value("${jdbc.maxConnectionsPerPartition}")
	private int maxConnectionsPerPartition;
	
	@Value("${jdbc.idleConnectionTestPeriodInMinutes}")
	private int idleConnectionTestPeriodInMinutes;
	
	@Value("${jdbc.statementsCacheSize}")
	private int statementsCacheSize;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public int getMaxConnectionsPerPartition() {
		return maxConnectionsPerPartition;
	}

	public void setMaxConnectionsPerPartition(int maxConnectionsPerPartition) {
		this.maxConnectionsPerPartition = maxConnectionsPerPartition;
	}

	public int getIdleConnectionTestPeriodInMinutes() {
		return idleConnectionTestPeriodInMinutes;
	}

	public void setIdleConnectionTestPeriodInMinutes(int idleConnectionTestPeriodInMinutes) {
		this.idleConnectionTestPeriodInMinutes = idleConnectionTestPeriodInMinutes;
	}

	public int getStatementsCacheSize() {
		return statementsCacheSize;
	}

	public void setStatementsCacheSize(int statementsCacheSize) {
		this.statementsCacheSize = statementsCacheSize;
	}

	
	
}
