package com.wp.boot;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.wp.boot.filter.CustomFilter;
import com.wp.boot.listener.CustomListener;
import com.wp.boot.servlet.CustomServlet;
/**
 * 
 * 远程调试 java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n –jar  
 */

@EnableCaching  //开启缓存
@ServletComponentScan
@SpringBootApplication
public class SpringBootWebApplication implements ServletContextInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
			servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/servlet");
			servletContext.addFilter("customFilter", new CustomFilter()).addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
			servletContext.addListener(new CustomListener());

	}
	/**
	 * 实现 servlet Filter Listener 的注册
	 * 1：下面的几个方法
	 * 2：实现接口ServletContextInitializer
	 * 3：使用注解 @ServletComponentScan 后直接通过@WebServlet、@WebFilter、@WebListener 注解自动注册
	 */
	
	/*@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new CustomServlet(),"/servlet");
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		//第二个参数是拦截路径，不填拦截所有
		return new FilterRegistrationBean(new CustomFilter(),servletRegistrationBean());
	}
	@Bean
	public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
		
		return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());
	}*/
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	
}
