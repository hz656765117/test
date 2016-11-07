package com.hz.business.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.User;
import com.hz.business.service.DaoManager;
import com.hz.business.service.UserService;


@Controller
@RequestMapping("/test")
public class TestController {
	@Resource DaoManager manager;
	@Resource UserService userService;
	//url  http://localhost:8080/ssm/test/test1.do
	@RequestMapping("/getUserList")
	public void toindex(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
		
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		System.out.println(time.format(new Date()) + "  register");
		System.out.println("UserName："+baseModel.getUser_login_name());
		System.out.println("Pwd："+baseModel.getUser_login_pwd());
		System.out.println(request.getMethod());
		
		
		JSONObject obj = new JSONObject();
		response.setContentType("text/json;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");
		
		List<User> users = userService.loginByApp(baseModel.getUser_login_name(), null);
		
		if(users != null  && users.size()>0){
			obj.put("success", true);
			obj.put("status", "1");
			obj.put("msg", "有数据，供测试用");
			obj.put("users", users);
		}else{
			obj.put("success", false);
			obj.put("status", "2");
			obj.put("msg", "无数据");
			obj.put("users", users);
		}
		
		response.getWriter().write(new Gson().toJson(obj));
		return;
	}
}
