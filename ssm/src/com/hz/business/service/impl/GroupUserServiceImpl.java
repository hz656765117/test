package com.hz.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.hz.base.Constants;
import com.hz.base.utils.DateUtil;
import com.hz.business.base.pojo.GroupUser;
import com.hz.business.base.pojo.GroupUserExample;
import com.hz.business.service.DaoManager;
import com.hz.business.service.GroupUserService;

public class GroupUserServiceImpl implements GroupUserService {
	@Resource DaoManager manager;
	
	public List<GroupUser> addGroupUser(String groupId, String userIds) {
		String[] users = userIds.split("\\|");
		List<GroupUser> list = new ArrayList<GroupUser>();
		if(users != null && users.length>0){
			for(String user : users){
				GroupUserExample example = new GroupUserExample();
				example.createCriteria().andGroupIdEqualTo(groupId).andStatusEqualTo(Constants.GROUP_STATUS_VALID).andUserIdEqualTo(user);
				List<GroupUser> uList = manager.getGroupUserMapper().selectByExample(example);
				if(uList != null && uList.size()>0){
					continue ;
				}
				GroupUser gu = new GroupUser();
				gu.setGroupId(groupId);
				gu.setStatus(1);
				gu.setUserId(user);
				gu.setCreateTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
				int result = manager.getGroupUserMapper().insertSelective(gu);
				if(result == 1){
					list.add(gu);
				}
			}
		}
		return list;
	}

	public boolean delGroupUser(String groupId, String userIds) {
		String[] users = userIds.split("\\|");
		if(users != null && users.length>0){
			for(String user : users){
				GroupUserExample example = new GroupUserExample();
				example.createCriteria().andUserIdEqualTo(user).andGroupIdEqualTo(groupId).andStatusEqualTo(1);
				int result = manager.getGroupUserMapper().deleteByExample(example);
				if(result != 1){
					 return false;
				}
			}
		}
		return true;
	}

	public List<GroupUser> listGroupUser(String groupId) {
		List<GroupUser> list = new ArrayList<GroupUser>();
		GroupUserExample example = new GroupUserExample();
		example.createCriteria().andGroupIdEqualTo(groupId).andStatusEqualTo(1);
		list = manager.getGroupUserMapper().selectByExample(example);
		return list;
	}

}
