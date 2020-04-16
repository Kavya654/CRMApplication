package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDatasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.jdbcAuthentication().dataSource(securityDatasource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/employees").hasRole("EMPLOYEE")
					.antMatchers("/leaders/**").hasRole("MANAGER")
					.antMatchers("/systems/**").hasRole("ADMIN")
					.and()
					.formLogin()
					.loginPage("/showLoginPage")
					.loginProcessingUrl("/authenticateUser")
					.permitAll().and().logout().logoutSuccessUrl("/").permitAll()
					.and()
					.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	
}
