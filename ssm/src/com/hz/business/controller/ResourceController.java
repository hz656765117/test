package com.hz.business.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.base.page.Page;
import com.box.base.page.PageList;
import com.box.base.page.Paginator;
import com.hz.base.Constants;
import com.hz.business.base.model.BaseModel;
import com.hz.business.controller.BaseController;

/**
 * 资源管理
 * @author HZBOX
 * @since 2016-10-09
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {
//	@Resource UserService userService;
//	@Resource DaoManager manager;
//	@Resource VerifyService verifyService;
//	@Resource SignService signService;
//	@Resource GroupService groupService;
//	@Resource ResourceService resourceService;
	
	@RequestMapping("/list")  
	public String list(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
		return "list";
	}
	
	@RequestMapping("/ajaxList")  
	public String ajaxList(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,@RequestParam(required=false, defaultValue="1") Integer pageIndex ,Model model) throws IOException{
		PageList<com.hz.business.base.pojo.Resource> resourceList;
		Paginator p = new Paginator();
		p.setPage(pageIndex);
		p.setPageSize(2);
		
		com.hz.business.base.pojo.Resource record = new com.hz.business.base.pojo.Resource();
		record.setStatus(Constants.RESOURCE_STATUS_VALID);
		List<com.hz.business.base.pojo.Resource> list = resourceService.listResource(record ,p);
		Page<com.hz.business.base.pojo.Resource> page = (Page<com.hz.business.base.pojo.Resource>) list;
		
		
		resourceList = new PageList<com.hz.business.base.pojo.Resource>(page, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("pageList", resourceList);
		return "resourceList";
	}
			

	 
	
}
