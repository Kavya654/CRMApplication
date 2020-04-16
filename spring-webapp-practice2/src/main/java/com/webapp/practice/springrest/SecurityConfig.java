package com.webapp.practice.springrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication().withUser("admin").password("$2a$10$i4xqOk4i/73PgqjEsr/eRe/2fLaaaCxOtHzZXnFZKb7Wf3yZR.Ohu").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
								.antMatchers("/register").hasRole("ADMIN")
								.antMatchers("/update/**").hasRole("ADMIN")
								.and()
								.formLogin()
								.loginPage("/showMyLoginPage")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
								.and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/").
								permitAll();
					
		
	}
	
	

}
