package com.wp.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wp.boot.bean.Users;
import com.wp.boot.dao.IUserDao;
import com.wp.boot.dao.IUserDaoByMybatis;
import com.wp.boot.dao.IUserDaoXml;
import com.wp.boot.service.IUserService;
import com.wp.boot.service.IUserServiceByMybatis;

/**
 * 	@CacheConfig：缓存配置
	@Cacheable：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调
	用方法获取数据，然后把数据添加到缓存中。适用于查找
	@CachePut：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的
	是，它每次都会触发真实方法的调用。适用于更新和插入
	@CacheEvict：主要针对方法配置，能够根据一定的条件对缓存进行清空。适用于删除

 */
@Service
public class UserServiceByMybatis implements IUserServiceByMybatis {
	
	@Resource
	private IUserDaoByMybatis userDao;
	@Resource
	private IUserDaoXml userDaoXml;
	
	@Override
	public List<Users> gerUsers() {
		return userDao.gerUsers();
	}

	@Override
	public int saveUser(Users users) {
		return userDao.saveUser(users);
	}

	@Override
	public int save(Users users) {
		return userDaoXml.save(users);
	}

	@Override
	public Users queryUsersById(Integer id) {
		return userDaoXml.queryUsersById(id);
	}

	@Override
	public List<Users> getUsersByList() {
		return userDaoXml.getUsersByList();
	}
	
	
	
}
