package com.hz.business.api;

import java.io.IOException;
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
import com.hz.base.utils.DateUtil;
import com.hz.base.utils.StringUtil;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.User;
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
import com.hz.business.service.UserService;

/**
 * 用户信息修改api
 * @author HZBOX
 * @since 2016-09-25
 */
@Controller
@RequestMapping("/sys")
public class UpdateUserInfoAPI extends BaseController {
	@Resource UserService userService;
	@Resource DaoManager manager;
	
		@RequestMapping("/updateUserInfo")  
		public void updateUserInfo(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			 
			
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
			 
			
			User user =	manager.getUserDao().selectByPrimaryKey(Integer.parseInt(baseModel.getUserId()));
			
			if( user != null ){
				if( StringUtil.isNotBlank(baseModel.getUser_login_name())){
					List<User> list = userService.selectByName(baseModel.getUser_login_name());
					if(list != null && list.size()>0){
						for(User u : list){
							if(u.getId()!= Integer.parseInt(baseModel.getUserId()) && baseModel.getUser_login_name().equals(u.getName())){
								obj.put("success", false);
								obj.put("msg", "该用户名已经存在");
								obj.put("status", "5");
								response.getWriter().write(new Gson().toJson(obj));
								return;
							}
						}
					}
					user.setName(baseModel.getUser_login_name());
					
				}
				
				if( StringUtil.isNotBlank(baseModel.getPicUrl())){
					user.setPicUrl(baseModel.getPicUrl());
				}
				
				if( StringUtil.isNotBlank(baseModel.getTel())){
					List<User> list = userService.selectByName(baseModel.getTel());
					if(list != null && list.size()>0){
						for(User u : list){
							if(u.getId()!= Integer.parseInt(baseModel.getUserId()) && baseModel.getTel().equals(u.getTel())){
								obj.put("success", false);
								obj.put("msg", "该电话已经被使用");
								obj.put("status", "6");
								response.getWriter().write(new Gson().toJson(obj));
								return;
							}
						}
					}
					user.setTel(baseModel.getTel());
				}
				
				if( StringUtil.isNotBlank(baseModel.getEmail())){
					List<User> list = userService.selectByName(baseModel.getEmail());
					if(list != null && list.size()>0){
						for(User u : list){
							if(u.getId()!= Integer.parseInt(baseModel.getUserId()) && baseModel.getEmail().equals(u.getEmail())){
								obj.put("success", false);
								obj.put("msg", "该邮箱已经被使用");
								obj.put("status", "6");
								response.getWriter().write(new Gson().toJson(obj));
								return;
							}
						}
					}
					user.setEmail(baseModel.getEmail());
				}
				
				if( StringUtil.isNotBlank(baseModel.getStuNo())){
					user.setStuNo(baseModel.getStuNo());
				}
				
				if( StringUtil.isNotBlank(baseModel.getSchool())){
					user.setSchool(baseModel.getSchool());
				}
				
				if( baseModel.getGender()== 1 ||  baseModel.getGender()== 2){
					user.setGender(baseModel.getGender());
				}
				user.setUpdateTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
				int success = manager.getUserDao().updateByPrimaryKeySelective(user);
				user.setPwd(null);
				obj.put("success", success ==1 ?true :false);
				obj.put("status", success ==1 ? 1 : 2);
				obj.put("msg",  success ==1 ? "修改成功" :"修改失败");
				obj.put("user", user);
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else{
				obj.put("success", false);
				obj.put("msg", "用户不存在");
				obj.put("status", "3");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			 
			 
		}
		
		
	
}
