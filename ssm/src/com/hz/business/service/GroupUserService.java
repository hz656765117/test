package com.hz.business.service;

import java.util.List;

import com.hz.business.base.pojo.GroupUser;

public interface GroupUserService {
	List<GroupUser> addGroupUser(String groupId,String userIds);
	
	
	boolean delGroupUser(String groupId,String userIds);
	
	 
	List<GroupUser> listGroupUser(String groupId);
}
