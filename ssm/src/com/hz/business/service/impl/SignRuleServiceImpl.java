package com.hz.business.service.impl;

import java.util.Date;
import java.util.List;

import com.hz.base.utils.DateUtil;
import com.hz.business.base.pojo.SignRule;
import com.hz.business.base.pojo.SignRuleExample;
import com.hz.business.service.BaseService;
import com.hz.business.service.SignRuleService;

public class SignRuleServiceImpl  extends BaseService  implements SignRuleService {

	public SignRule addSignRule(SignRule signRule) {
		signRule.setCreateTime(DateUtil.convertDateToString("yyyy-MM-dd", new Date()));
		signRule.setId("1");
		
		int result = manager.getSignRuleMapper().insertSelective(signRule);
		return result == 1 ? signRule : null;
	}

	public SignRule updateSignRule(SignRule signRule) {
		int result = manager.getSignRuleMapper().updateByPrimaryKeySelective(signRule);
		return result == 1 ? signRule : null;
	}

	public boolean delSignRule(String ruleId) {
		int result = manager.getSignRuleMapper().deleteByPrimaryKey(ruleId);
		return result == 1 ? true : false;
	}

	public List<SignRule> listSignRule(String groupId) {
		SignRuleExample example = new SignRuleExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		List<SignRule> list = manager.getSignRuleMapper().selectByExample(example);
		return list;
	}

}
