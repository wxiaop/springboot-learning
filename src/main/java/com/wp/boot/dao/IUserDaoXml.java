package com.wp.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.wp.boot.bean.Users;

/**
 * Mybatis xml实现方式
 * 
 * 在配置文件中配置mybatis xml文件的路径
 *	mybatis.mapper-locations: classpath:mybatis/*.xml
 *	mybatistype-aliases-package: com.wp.boot.bean   
 * 
 */
@Mapper
public interface IUserDaoXml {
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
	 * 根据用户名和密码查询用户
	 * com.wp.boot.dao 
	 * 方法名：getUser
	 * 创建人：wenpeng
	 * 时间：2017年6月27日-下午7:45:04 
	 * @param username
	 * @param password
	 * @return Users
	 * @exception 
	 * @since  1.0.0
	 */
	public Users getUser(@Param("username") String username,@Param("password") String password);
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
