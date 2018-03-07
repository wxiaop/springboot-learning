package com.wp.boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 实现 servlet Filter Listener 的方法
 * 1：下面的几个方法 @see SpringBootWebApplication
 * 2：实现接口ServletContextInitializer
 * 3：使用注解 @ServletComponentScan 后直接通过@WebServlet、@WebFilter、@WebListener 注解自动注册
 */

public class CustomFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("destory");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");
	}

}
