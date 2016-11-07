package com.hz.business.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.User;
import com.hz.business.service.DaoManager;

@Controller
@RequestMapping("/sys")
public class SysController extends BaseController {
	@Resource DaoManager manager;
	
	
	//url  http://localhost:8080/ssm/sys/register.do
		@RequestMapping("/register")
		public void register(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			System.out.println(time.format(new Date()) + "  register");
//			System.out.println("UserName："+baseModel.getUserName());
//			System.out.println("Pwd："+baseModel.getPwd());
			
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			
			User user = new User();
			
//			if(StringUtils.isBlank(baseModel.getUserName())){
//				obj.put("success", false);
//				obj.put("msg", "用户名不能为空！");
//				response.getWriter().write(new Gson().toJson(obj));
//				return;
//			}
//			if(StringUtils.isBlank(baseModel.getPwd())){
//				obj.put("success", false);
//				obj.put("msg", "密码不能为空！");
//				response.getWriter().write(new Gson().toJson(obj));
//				return;
//			}
			
//			user.setName(baseModel.getUserName());
			
			List<User> list = manager.getUserDao().selectByUser(user);
			if(list !=null && list.size()>0 ){
				obj.put("success", false);
				obj.put("msg", "该用户名已经注册！");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else{
//				user.setPwd(baseModel.getPwd());
//				user.setCreatetime(time.format(new Date()));
			    int code = manager.getUserDao().insertSelective(user);
				if(code == 1){
					obj.put("success", true);
					obj.put("msg", "注册成功！");
				}else{
					obj.put("success", false);
					obj.put("msg", "注册失败！");
				}
			}
			response.getWriter().write(new Gson().toJson(obj));
			 
		}
		@RequestMapping("/login")
		public void login(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			System.out.println(time.format(new Date()) + "  login");
//			System.out.println("UserName："+baseModel.getUserName());
//			System.out.println("Pwd："+baseModel.getPwd());
			
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			User user = new User();
//			user.setName(baseModel);
//			user.setPwd(baseModel.getPwd());
		    List<User> list = manager.getUserDao().selectByUser(user);
			if(list != null && list.size()>0){
				obj.put("success", true);
				obj.put("msg", "登录成功！");
			}else{
				obj.put("success", false);
				obj.put("msg", "登录失败！");
			}
			
			response.getWriter().write(new Gson().toJson(obj));
			 
		}
		
		
		@RequestMapping(value="/register1", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String register1(HttpServletRequest request,@ModelAttribute("baseModel") BaseModel baseModel,Model model){
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			System.out.println(time.format(new Date()) + "  register1");
			JSONObject obj = new JSONObject();
			obj.put("success", true);
			obj.put("msg", "请求成功！");
			
			return obj.toString();
		}
		
		
		
		
		
		@RequestMapping("/testrequest")
		public void testrequest(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			System.out.println(time.format(new Date()) + "  testreuqest");
			System.out.println(baseModel.getAddress());
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			
			obj.put("success", true);
			obj.put("msg", "请求成功！");
		 
			response.getWriter().write(new Gson().toJson(obj));
		}
		
		
		
		
		
		@RequestMapping("/toregister")
		public String toregister(HttpServletRequest request ,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			return  "register";
		}
		
		
		@RequestMapping("/tologin")
		public String tologin(HttpServletRequest request ,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			return  "login";
		}
		
/*		@RequestMapping("/login")
		public String login(HttpServletRequest request ,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			return  "index";
		}*/
		
	
}
