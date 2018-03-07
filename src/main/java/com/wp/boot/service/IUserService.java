package com.wp.boot.service;

import java.util.List;

import com.wp.boot.bean.Users;

public interface IUserService {
	/**
	 * 
	 * 保存用户
	 * com.wp.boot.dao 
	 * 方法名：save
	 * 创建人：wenpeng
	 * 时间：2017年6月27日-下午7:46:28 
	 * @param users
	 * @return Users
	 * @exception 
	 * @since  1.0.0
	 */
	public Users save(Users users);
	/**
	 * 
	 * 根据ID获取
	 * com.wp.boot.dao 
	 * 方法名：queryUsersById
	 * 创建人：wenpeng
	 * 时间：2017年6月27日-下午7:49:00 
	 * @param id
	 * @return Users
	 * @exception 
	 * @since  1.0.0
	 */
	public Users queryUsersById(Integer id);
	public Users getUser(String username,String password);
	public List<Users> getUsersByList();
}	
