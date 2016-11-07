package com.hz.business.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hz.business.base.dao.GroupMapper;
import com.hz.business.base.dao.GroupUserMapper;
import com.hz.business.base.dao.ResourceMapper;
import com.hz.business.base.dao.SignMapper;
import com.hz.business.base.dao.SignRuleMapper;
import com.hz.business.base.dao.UserMapper;
import com.hz.business.base.dao.VerifyMapper;

/**
 * Dao管理类，管理所有的dao
 * @author HZBOX
 * @since 2016-09-24
 */
@Component
public class DaoManager {
	@Resource UserMapper userDao;
	@Resource VerifyMapper VerifyDao;
	@Resource SignMapper signMapper;
	@Resource SignRuleMapper signRuleMapper;
	@Resource GroupMapper groupMapper;
	@Resource ResourceMapper resourceMapper;
	@Resource GroupUserMapper groupUserMapper;
	 

	public UserMapper getUserDao() {
		return userDao;
	}

	public VerifyMapper getVerifyDao() {
		return VerifyDao;
	}

	public SignMapper getSignMapper() {
		return signMapper;
	}

	public SignRuleMapper getSignRuleMapper() {
		return signRuleMapper;
	}

	public GroupMapper getGroupMapper() {
		return groupMapper;
	}

	public ResourceMapper getResourceMapper() {
		return resourceMapper;
	}

	public GroupUserMapper getGroupUserMapper() {
		return groupUserMapper;
	}
	
	
	
	
}
