package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/*
 * Spring Security default design the login and logout pages in application.
 * 
 *Login URL:- http://localhost:8080/login
 *Logout URL:- http://localhost:8080/logout
 *
 * To test with different user or role first logout the current user or role.
 */
