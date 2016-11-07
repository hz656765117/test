package com.hz.business.service;

import java.util.List;

import com.hz.business.base.pojo.Sign;



public interface SignService {
	/**
	 * 签到
	 * @param sign
	 * @return
	 */
	int addSign(Sign sign);
	
	/**
	 * 查询群组签到信息
	 * @param groupId
	 * @param userId
	 * @param searchId
	 * @param status
	 * @return
	 */
	List<Sign> findGroupSign(String groupId , String userId , int status ,int type);
}
