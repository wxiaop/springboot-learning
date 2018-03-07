package com.wp.boot.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wp.boot.bean.Users;
import com.wp.boot.component.WpJavaMailComponent;
import com.wp.boot.service.IUserService;
//@RequestMapping("api")
import com.wp.boot.service.IUserServiceByMybatis;

@RestController()
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IUserServiceByMybatis userSeviceByMybatis;
	@Autowired
	private WpJavaMailComponent javaMailComponent;
	@RequestMapping(value="user")
	public Users getUsers(String username,String password){
		return userService.getUser(username, password);
	}
	
	@RequestMapping(value="userById")
	public Users getUsers(Integer id){
		return userService.queryUsersById(id);
	}
	@CrossOrigin(origins="http://localhost:8080")  //跨域请求
	@RequestMapping("users")
	public List<Users> getUsersByList(){
		return userService.getUsersByList();
	}
	
	@RequestMapping("mail")
	public String sendMail(String mail) throws UnsupportedEncodingException, MessagingException{
		return javaMailComponent.send(mail, "Success");
	}
	
	@RequestMapping("mybatis/users")
	public List<Users> getUsersByMyBatis(){
		return userSeviceByMybatis.gerUsers();
	}
	@RequestMapping("mybatis/save")
	public int saveByMyBatis(){
		Users users = new Users();
		users.setPassword("123");
		users.setUsername("TestUsername");
		return userSeviceByMybatis.saveUser(users);
	}
	@RequestMapping("mybatisXml/users")
	public List<Users> getusersList(){
		return userSeviceByMybatis.getUsersByList();
	}
	
	@RequestMapping("mybatisXml/save")
	public Users saveUsersXml(){
		Users users = new Users();
		users.setAddress("Zunyi");
		users.setAge(20);
		users.setEmail("1091654568@qq.com");
		users.setUsername("文鹏");
		users.setPassword("132");
		userSeviceByMybatis.save(users);
		return users;
	}
	
	@RequestMapping("mybatisXml/query")
	public Users queryUsersById(Integer id){
		return userSeviceByMybatis.queryUsersById(id);
	}
	
}
