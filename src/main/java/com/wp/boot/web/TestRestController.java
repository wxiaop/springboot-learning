package com.wp.boot.web;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.wp.boot.bean.Users;
import com.wp.boot.service.IUserService;

@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class TestRestController {
	@Resource 
	private IUserService userService;
	

	@RequestMapping(value = "/update")
	public Users update(@RequestBody JsonNode jsonNode) {
		System.out.println("===========");
		System.out.println("jsonNode=" + jsonNode);
		Users bean = userService.queryUsersById(jsonNode.get("id").asInt(1));
		if(bean == null){
			bean = new Users();
		}
		bean.setUsername("测试");
		bean.setCreateTime(new Date());
		userService.save(bean);
		return bean;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public Users update2(@PathVariable(value = "id") Integer id) {
		Users bean = userService.queryUsersById(id);
		if(bean == null){
			bean = new Users();
		}
		bean.setUsername("测试");
		bean.setCreateTime(new Date());
		userService.save(bean);
		return bean;
	}

}

