package com.hz.business.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.Group;
import com.hz.business.base.pojo.Sign;
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
import com.hz.business.service.GroupService;
import com.hz.business.service.SignService;
import com.hz.business.service.UserService;
import com.hz.business.service.VerifyService;

/**
 * 创建小组api
 * @author HZBOX
 * @since 2016-09-27
 */
@Controller
@RequestMapping("/sys")
public class FindGroupSignAPI extends BaseController {
	@Resource UserService userService;
	@Resource DaoManager manager;
	@Resource VerifyService verifyService;
	@Resource SignService signService;
	@Resource GroupService groupService;
	
		@RequestMapping("/findGroupSign")  
		public void findGroupSign(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			 
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			
			if(StringUtils.isBlank(baseModel.getUserId())){
				obj.put("success", false);
				obj.put("msg", "用户ID不能为空");
				obj.put("status", "4");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
		 
			if(StringUtils.isBlank(baseModel.getGroupId())){
				obj.put("success", false);
				obj.put("msg", "小组ID不能为空");
				obj.put("status", "5");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			if(baseModel.getType()!=1 &&  baseModel.getType()!=2 && baseModel.getType()!=3 &&baseModel.getType()!=4 ){
				obj.put("success", false);
				obj.put("msg", "查询类型异常");
				obj.put("status", "6");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
 
			
			
			//查询所有时，校验当前用户是否为群主
			if(baseModel.getType()==1){
				Group group = manager.getGroupMapper().selectByPrimaryKey(Integer.parseInt(baseModel.getGroupId()));
				if(group != null && !baseModel.getUserId().equals(group.getCreatePersonId())){
					obj.put("success", false);
					obj.put("msg", "该用户不是群主，不能查询该组所有签到人员");
					obj.put("status", "3");
					response.getWriter().write(new Gson().toJson(obj));
					return;
				}
			}
			
			List<Sign> list =  signService.findGroupSign(baseModel.getGroupId(), baseModel.getUserId(), baseModel.getStatus() , baseModel.getType());
			 
			
			if(list != null  && list.size()>0){
				obj.put("success", true);
				obj.put("status", "1");
				obj.put("msg", "查询成功");
				obj.put("list", list);
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else{
				obj.put("success", false);
				obj.put("status", "2");
				obj.put("msg", "无数据");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			} 
			 
		}

	 
	
}
