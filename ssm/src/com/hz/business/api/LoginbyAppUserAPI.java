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
import com.hz.business.base.pojo.User;
import com.hz.business.controller.BaseController;
import com.hz.business.service.UserService;

/**
 * APP登录api
 * @author HZBOX
 * @since 2016-09-25
 */
@Controller
@RequestMapping("/sys")
public class LoginbyAppUserAPI extends BaseController {
	@Resource UserService userService;
	
		@RequestMapping("/loginbyAppUser")  
		public void loginbyAppUser(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			 
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
		
			
			if(StringUtils.isBlank(baseModel.getUser_login_name())){
				obj.put("success", false);
				obj.put("msg", "用户名不能为空");
				obj.put("status", "3");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			if(StringUtils.isBlank(baseModel.getUser_login_pwd())){
				obj.put("success", false);
				obj.put("msg", "密码不能为空");
				obj.put("status", "4");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			List<User> users = userService.loginByApp(baseModel.getUser_login_name(), null);
			if(users != null && users.size()>0){
				for(User u : users){
					if(u.getPwd().equals(baseModel.getUser_login_pwd())){
						obj.put("success", true);
						obj.put("status", "0");
						obj.put("msg", "登录成功");
						obj.put("user", u);
						response.getWriter().write(new Gson().toJson(obj));
						return;
					}
				}
				obj.put("success", false);
				obj.put("status", "2");
				obj.put("msg", "密码不正确");
				response.getWriter().write(new Gson().toJson(obj));
				return;
				 
			}else{
				obj.put("success", false);
				obj.put("status", "1");
				obj.put("msg", "用户名不存在");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			 
		}
		
		
	
}
