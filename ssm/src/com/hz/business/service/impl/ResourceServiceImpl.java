package com.hz.business.service.impl;

import java.util.Date;
import java.util.List;

import com.box.base.page.PageHelper;
import com.box.base.page.Paginator;
import com.hz.base.utils.DateUtil;
import com.hz.business.base.pojo.Resource;
import com.hz.business.base.pojo.ResourceExample;
import com.hz.business.service.DaoManager;
import com.hz.business.service.ResourceService;

public class ResourceServiceImpl implements ResourceService {
	
	@javax.annotation.Resource  DaoManager manager;
	
	
	public boolean addResource(Resource record) {
		record.setCreateTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
		record.setStatus(1);
		int result = manager.getResourceMapper().insertSelective(record);
		return result == 1 ? true : false ;
	}


	public List<Resource> listResource(Resource record,Paginator p) {
		ResourceExample example = new ResourceExample();
		example.createCriteria().andStatusEqualTo(record.getStatus());
		PageHelper.startPage(p.getPage(), p.getPageSize());
		List<Resource> list = manager.getResourceMapper().selectByExample(example);
		return list;
	}

}
