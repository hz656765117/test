package com.hz.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.hz.base.Constants;
import com.hz.base.utils.StringUtil;
import com.hz.business.base.pojo.Sign;
import com.hz.business.base.pojo.SignRule;
import com.hz.business.base.pojo.SignRuleExample;
import com.hz.business.base.pojo.User;
import com.hz.business.service.DaoManager;
import com.hz.business.service.SignService;

public class SignServiceImpl implements SignService {
	@Resource DaoManager manager;
	
	public int addSign(Sign sign) {
		// TODO Auto-generated method stub
		SignRuleExample example = new SignRuleExample();
		example.createCriteria().andGroupIdEqualTo(sign.getGroupId());
		List<SignRule> list = manager.getSignRuleMapper().selectByExample(example);
		
		if(list !=null && list.size() > 0){
			boolean signSuccess = false;
			for(SignRule sr : list){
				Double distance = com.hz.base.utils.StringUtil.getDistance(sign.getLongitude(), sign.getLatitude(), sr.getLongitude(), sr.getLatitude());
				Double differ = sr.getPrec() - distance ;
				if(differ >0){//在允许的签到范围内签到
					signSuccess = true ;
					break;
				}
			}
			if(!signSuccess){//不符合签到规则
				return 9;
			}
		    User user = manager.getUserDao().selectByPrimaryKey(Integer.valueOf(sign.getSignPersonId()));
		    
		    if( StringUtil.isBlank(user.getPicUrl())){//个人图片为空
		    	return 10;
		    }
		    
			boolean validSuccess = validPic(user.getPicUrl(),sign.getUrl());
			
			if(!validSuccess){//人脸识别失败
				return 11;
			}
			
			sign.setSignRuleId(list.get(0).getId());
			sign.setType(Constants.SIGN_TYPE_SUCCESS);
			int result = manager.getSignMapper().insertSelective(sign);
			if(result == 1 ){
				return 1;
			}else{
				return 2;
			}
		}else{
			sign.setType(Constants.SIGN_TYPE_SUCCESS);
			int result = manager.getSignMapper().insertSelective(sign);
			if(result == 1 ){
				return 1;
			}else{
				return 2;
			}
		//	return 0;
		}
	}
	
	/**
	 * 人脸识别
	 * @param sourcePicUrl 源图片url
	 * @param signPicUrl   签到图片url
	 * @return
	 */
	public boolean validPic(String sourcePicUrl , String signPicUrl){
		//调用人脸识别api 暂未提供出来
		
		
		
		return true;
	}

	public List<Sign> findGroupSign(String groupId, String userId,  int status , int type) {
		List<Sign> list = manager.getSignMapper().selectGroupSign(groupId, userId, status ==0 ? null : status, type);
		return list;
	}

}
