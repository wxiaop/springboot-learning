package com.wp.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import com.wp.boot.bean.Users;
/**
 * 
 * JPA 实现方法
 * 1. 注解实现 @RepositoryDefinition
 * 2. 继承Repository(CrudRepository,JpaRepository,Repository)
 */

@RepositoryDefinition(domainClass=Users.class,idClass=Integer.class)
public interface IUserDao{
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
	@Query("FROM Users WHERE username = :username AND password = :password")
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
	@Query("FROM Users")
	public List<Users> getUsersByList();
}
