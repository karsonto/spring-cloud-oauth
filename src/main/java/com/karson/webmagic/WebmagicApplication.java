package com.karson.webmagic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication()
@ServletComponentScan
@EnableResourceServer
@EnableAuthorizationServer
public class WebmagicApplication  {
	 
	public static void main(String[] args) {
		SpringApplication.run(WebmagicApplication.class, args);
	}

	 
}
