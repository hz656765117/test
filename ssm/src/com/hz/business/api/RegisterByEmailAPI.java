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
import com.hz.base.Constants;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.User;
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
import com.hz.business.service.UserService;
import com.hz.business.service.VerifyService;
/**
 * 邮箱注册api
 * @author HZBOX
 * @since 2016-09-24
 */
@Controller
@RequestMapping("/sys")
public class RegisterByEmailAPI extends BaseController {
	@Resource DaoManager manager;
	@Resource UserService userService;
	@Resource VerifyService verifyService;
	
	
	//url  http://localhost:8080/ssm/registerByTel.do
		@RequestMapping("/registerByEmail")  
		public void registerByEmail(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
		
			User user = new User();
			
			if(StringUtils.isBlank(baseModel.getUser_login_name())){
				obj.put("success", false);
				obj.put("msg", "用户名不能为空！");
				obj.put("status", "5");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			if(StringUtils.isBlank(baseModel.getUser_login_pwd())){
				obj.put("success", false);
				obj.put("msg", "密码不能为空！");
				obj.put("status", "6");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			if(StringUtils.isBlank(baseModel.getEmail())){
				obj.put("success", false);
				obj.put("msg", "邮箱不能为空！");
				obj.put("status", "7");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			if(StringUtils.isBlank(baseModel.getAuth_code())){
				obj.put("success", false);
				obj.put("msg", "验证码不能为空！");
				obj.put("status", "8");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}	
			
			
			user.setName(baseModel.getUser_login_name());
			List<User> list = userService.selectByUser(user);
			if(list !=null && list.size()>0 ){
				obj.put("success", false);
				obj.put("msg", "该用户名已经注！");
				obj.put("status", "2");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else{
				user = new User();
				user.setEmail(baseModel.getEmail());
				list = userService.selectByUser(user);
				if(list !=null && list.size()>0 ){
					obj.put("success", false);
					obj.put("msg", "该邮箱已经使用！");
					obj.put("status", "3");
					response.getWriter().write(new Gson().toJson(obj));
					return;
				}else{
					user.setName(baseModel.getUser_login_name());
					user.setPwd(baseModel.getUser_login_pwd());
					user.setEmail(baseModel.getEmail());
					user.setCreateTime(time.format(new Date()));
					boolean validcode = verifyService.validCode( baseModel.getEmail() , Constants.VERIFY_TYPE_EMAIL +"", baseModel.getAuth_code());
				   
				    if(validcode){
				    	 int code = manager.getUserDao().insertSelective(user);
				    	 if(code == 1){
								obj.put("success", true);
								obj.put("status", "0");
								obj.put("msg", "注册成功！");
								obj.put("user", user);
								response.getWriter().write(new Gson().toJson(obj));
								return;
							}else{
								obj.put("success", false);
								obj.put("status", "4");
								obj.put("msg", "注册失败！");
								response.getWriter().write(new Gson().toJson(obj));
								return;
							}
					}else{
						obj.put("success", false);
						obj.put("msg", "验证码错误！");
						obj.put("status", "1");
						response.getWriter().write(new Gson().toJson(obj));
						return;
					}
					
				}
			}
			
			
			
			
			
			 
		}
		
		
	
}
