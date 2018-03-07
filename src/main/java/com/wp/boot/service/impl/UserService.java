package com.wp.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wp.boot.bean.Users;
import com.wp.boot.dao.IUserDao;
import com.wp.boot.service.IUserService;

/**
 * 	@CacheConfig：缓存配置
	@Cacheable：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调
	用方法获取数据，然后把数据添加到缓存中。适用于查找
	@CachePut：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的
	是，它每次都会触发真实方法的调用。适用于更新和插入
	@CacheEvict：主要针对方法配置，能够根据一定的条件对缓存进行清空。适用于删除

 */
@CacheConfig(cacheNames="testCache")
@Service
public class UserService implements IUserService {
	
	@Resource
	private IUserDao userDao;
	
	@Override
	public Users save(Users users) {
		return userDao.save(users);
	}
	@Cacheable
	@Override
	public Users queryUsersById(Integer id) {
		return userDao.queryUsersById(id);
	}
	@Override
	public Users getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

	@Override
	@Cacheable()
	public List<Users> getUsersByList() {
		System.out.println("查询功能，缓存找不到，直接读库");
		return userDao.getUsersByList();
	}

	
	
	
	
}
