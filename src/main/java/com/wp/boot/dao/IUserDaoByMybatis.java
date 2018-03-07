package com.wp.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.wp.boot.bean.Users;

/**
 * Mybatis 注解实现方式、
 * 
 */
@Mapper
public interface IUserDaoByMybatis {
	
	@Select("SELECT id,username,password,create_time FROM users")
	@Results(value = { @Result(column = "create_time", property= "createTime", jdbcType=JdbcType.TIMESTAMP ) })
	public List<Users> gerUsers();
	@Insert("INSERT INTO users(username,password) VALUES(#{username},#{password})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public int saveUser(Users users);
	
}
