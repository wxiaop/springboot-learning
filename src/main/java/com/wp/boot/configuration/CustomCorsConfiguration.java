package com.wp.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 
 *	全局跨域配置
 * CustomCorsConfiguration
 * 创建人:wenpeng
 * 时间：2017年6月27日-下午8:25:56
 */
@Configuration     //这个注解表示这是一个配置文件   比如applicationContent.xml
public class CustomCorsConfiguration {
	@Bean  // 这个注解表示这是一个bean   <bean ></bean>
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
			}
		};
	}
}