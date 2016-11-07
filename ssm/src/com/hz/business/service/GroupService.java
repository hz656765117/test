package com.hz.business.service;

import java.util.List;

import com.hz.business.base.pojo.Group;



public interface GroupService {
	/**
	 * 创建群组
	 * @param sign
	 * @return
	 */
	Group createGroup(String userId , String groupName , String groupUsers ,String groupDesc );
	
	/**
	 * 群组查询
	 * @param userId
	 * @param type
	 * @return
	 */
	List<Group> groupListByUserId(String userId ,int type);
	
	boolean delGroup(String groupId);
	
	 
}
