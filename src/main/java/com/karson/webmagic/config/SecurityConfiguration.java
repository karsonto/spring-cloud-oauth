package com.karson.webmagic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
 
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
 
    private UserDetailsService userDetailsService;
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		   http.requestMatchers() 
			    .antMatchers("/login", "/oauth/authorize","/bower_components/**",
		                   "/build/**",
		                   "/customize/**",
		                   "/dist/**",
		                   "/documentation/**",
		                   "/upload/**",
		                   "/plugins/**")
		        .and()
		        .authorizeRequests().antMatchers("/bower_components/**",
		                   "/build/**",
		                   "/customize/**",
		                   "/dist/**",
		                   "/documentation/**",
		                   "/upload/**",
		                   "/plugins/**"
		               ).permitAll()
		        .anyRequest()
		        .authenticated()
		        .and()
		        .formLogin().loginPage("/login")// 登录url请求路径 (3)
                .defaultSuccessUrl("/home").permitAll().and() // 登录成功跳转路径url(4)
                .logout().permitAll();
	}
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 

	        auth.userDetailsService(userDetailsService);
}
}