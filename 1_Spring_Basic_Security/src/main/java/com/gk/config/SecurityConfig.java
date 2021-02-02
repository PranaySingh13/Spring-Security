package com.gk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //It tells Spring Security that it is a web security configuration.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	/*
	 * AUTHENTICATION :- the process of verifying who a user is.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Set Your Configuration on the Auth Object
		auth.inMemoryAuthentication()
			.withUser("Pranay")
			.password("abc123")
			.roles("USER")
			.and() //For bunch of users
			.withUser("GK Software Solutions")
			.password("xyz123")
			.roles("ADMIN");
	}
	
	//To encode the password in hash key from string input
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	/*
	 * AUTHORIZATION :-  the process of verifying what they have access to.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			
			//most restricted URL Should be at TOP because if we apply base url at top it will permit all urls 
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER","ADMIN")
			.antMatchers("/").permitAll() //Specify the paths using wildcards(**) /** indicates all paths
			.and()
			.formLogin();
	}
}
