package com.karson.webmagic.service;

import org.springframework.stereotype.Service;

import com.karson.webmagic.dao.UserDao;
import com.karson.webmagic.domain.Role;

import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class  UserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		 com.karson.webmagic.domain.User geOperator = userDao.findByUsername(username);
	        if(geOperator == null){  
	           // throw new UsernameNotFoundException("","用户名错误");  
	        }  
	        //加载该用户权限  
	        Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(geOperator);  

	        boolean enabled = true;  
	        boolean accountNonExpired = true;  
	        boolean credentialsNonExpired = true;  
	        boolean accountNonLocked = geOperator.getCanuse()==1;  	  
	        UserDetails userdetails = new User(username, geOperator.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);  
	                   
	        return userdetails;  

	}

	private Set<GrantedAuthority> obtainGrantedAuthorities( com.karson.webmagic.domain.User  geOperator) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		List<Role> roles= geOperator.getRoles();
		for(Role role:roles) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
		}
		return setAuths;
	}	
}
