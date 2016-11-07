package com.hz.business.service;

import java.util.List;

import com.box.base.page.Paginator;
import com.hz.business.base.pojo.Resource;

public interface ResourceService {
	boolean addResource(Resource record);
	List<Resource> listResource(Resource record,Paginator p);
}	
