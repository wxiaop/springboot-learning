package com.wp.boot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.wp.boot.bean.Users;

public interface IUserServiceByMybatis {
	
	public List<Users> gerUsers();
	
	public int saveUser(Users users);
	
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
	public int save(Users users);
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
	/**
	 * 
	 * 获取全部用户
	 * com.wp.boot.dao 
	 * 方法名：getUsersByList
	 * 创建人：wenpeng
	 * 时间：2017年6月27日-下午7:45:25 
	 * @return List<Users>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Users> getUsersByList();
}	
