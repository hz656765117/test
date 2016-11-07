package com.hz.business.service;

import java.util.List;

import com.hz.business.base.pojo.User;

public interface UserService {
	/**
	 * 根据用户对象查询
	 * @param record
	 * @return
	 */
	 List<User> selectByUser(User record);
	 
	 /**
	  * app登录
	  * @param name
	  * @param pwd
	  * @return
	  */
	 List<User> loginByApp(String name ,String pwd);
	 
	 /**
	  * 根据用户名查询（用户名 邮箱 手机号）
	  * @param name
	  * @return
	  */
	 public List<User> selectByName(String name) ;
}
