package com.karson.webmagic.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;

@Order(1)
//重点
@WebFilter(filterName = "testFilter1", urlPatterns = "/*")
public class TestFilterFirst implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 System.out.println("TestFilter1");
		  HttpServletRequest req  = (HttpServletRequest) request;
		  HttpServletResponse res  = (HttpServletResponse) response;
		  System.out.println();
		  Map<String,String[]> map = req.getParameterMap();
		  Set<String> set = map.keySet();
		  for (String s:set) {
			  System.out.println(s);
			  System.out.println(map.get(s).toString());
		  }
		 chain.doFilter(request,response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
}