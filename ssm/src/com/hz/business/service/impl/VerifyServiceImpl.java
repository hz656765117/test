package com.hz.business.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.base.Constants;
import com.hz.base.utils.DateUtil;
import com.hz.business.base.pojo.Verify;
import com.hz.business.base.pojo.VerifyExample;
import com.hz.business.base.pojo.VerifyExample.Criteria;
import com.hz.business.service.DaoManager;
import com.hz.business.service.VerifyService;
@Service
@Transactional
public class VerifyServiceImpl implements VerifyService {
	@Resource DaoManager manager;
	
	public boolean insert(String name, String code, int type) {
		Verify verify = new Verify();
		verify.setMailortel(name);
		verify.setCode(code);
		verify.setType(type+"");
		verify.setStatus("1");
		verify.setCreateTime(DateUtil.getDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		int result = manager.getVerifyDao().insertSelective(verify);
		return result == 1 ? true : false ;
	}

	public boolean validCode(String name, String type, String code) {
		boolean success = false;
		
		VerifyExample example = new VerifyExample();
		Criteria criteria = 	example.createCriteria();
		criteria.andCodeEqualTo(code).andMailortelEqualTo(name).andTypeEqualTo(type).andStatusEqualTo(Constants.VERIFY_STATUS_VALID+"");
		List<Verify> verifys = manager.getVerifyDao().selectByExample(example);
		if(verifys != null & verifys.size()>0){
			success = true;
			//一次验证之后就修改验证码状态
			Verify record = verifys.get(0);
			record.setStatus(Constants.VERIFY_STATUS_INVALID+"");
			manager.getVerifyDao().updateByPrimaryKeySelective(record);
			
		}
		return success;
	}
 

}
