package com.hz.business.service;

import java.util.List;

import com.hz.business.base.pojo.SignRule;

public interface SignRuleService {
	SignRule addSignRule(SignRule signRule);
	
	SignRule updateSignRule(SignRule signRule);
	
	boolean delSignRule(String ruleId);
	
	List<SignRule> listSignRule(String groupId);
	
}
