package com.edu.realestate.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Configuration
//Import(ServiceConfig.class)
//PropertySource("config.properties")
public class TestConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource reDS() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setUrl(env.getProperty("jdbc.url"));
		return ds;
	}
}
