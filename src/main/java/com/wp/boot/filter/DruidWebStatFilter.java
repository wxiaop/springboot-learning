package com.wp.boot.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/*
 * Druid 监控页面的配置
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns =
"/*", initParams = { @WebInitParam(name = "exclusions", value
= "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") })
public class DruidWebStatFilter extends WebStatFilter {
	
}