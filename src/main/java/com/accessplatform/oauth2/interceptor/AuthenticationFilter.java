package com.accessplatform.oauth2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class AuthenticationFilter extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception
	{
		System.out.println("done");
		
		
		
		return true;
		
	}

}
