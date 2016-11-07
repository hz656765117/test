package com.hz.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.business.base.pojo.User;
import com.hz.business.service.DaoManager;

@Service
@Transactional
public class UserServiceImpl implements com.hz.business.service.UserService {
	@Resource DaoManager manager;
	
	public List<User> selectByUser(User record) {
		return manager.getUserDao().selectByUser(record);
	}
	public List<User> loginByApp(String name ,String pwd) {
		User record = new User();
		record.setName(name);
		if(StringUtils.isNotBlank(pwd)){
			record.setPwd(pwd);
		}
		return manager.getUserDao().selectByNameAndPwd(record);
	}
	
	public List<User> selectByName(String name) {
		User record = new User();
		record.setName(name);
		return manager.getUserDao().selectByNameAndPwd(record);
	}
	
	
	
	
	
	
	
	
	
	
 
	
	
	

}
