package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// helper variable
	@Autowired
	private Environment env;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public DataSource securityDatasource() {

		ComboPooledDataSource securityDatasource = new ComboPooledDataSource();
		try {
			securityDatasource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException();
		}

		logger.info("url:" + env.getProperty("jdbc.url"));
		logger.info("user:" + env.getProperty("jdbc.user"));

		securityDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDatasource.setUser(env.getProperty("jdbc.user"));
		securityDatasource.setPassword(env.getProperty("jdbc.password"));

		securityDatasource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDatasource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDatasource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDatasource.setIdleConnectionTestPeriod(getIntProperty("connection.pool.maxIdleTime"));

		return securityDatasource;
	}

	private int getIntProperty(String propname) {

		String propval = env.getProperty(propname);
		int propvalInt = Integer.parseInt(propval);
		return propvalInt;
	}

}
