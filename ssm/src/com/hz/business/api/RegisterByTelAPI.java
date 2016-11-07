package com.hz.business.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
/**
 * 手机注册api
 * @author HZBOX
 * @since 2016-09-24
 */
@Controller
@RequestMapping("/sys")
public class RegisterByTelAPI extends BaseController {
	@Resource DaoManager manager;
	
	
	//url  http://localhost:8080/ssm/registerByTel.do
	@RequestMapping("/registerByTel") 
		public void register(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			obj.put("success", false);
			obj.put("msg", "用户名不能为空！");
//			User user = new User();
//			
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
//			
//			user.setName(baseModel.getUserName());
//			
//			List<User> list = manager.getUserDao().selectByUser(user);
//			if(list !=null && list.size()>0 ){
//				obj.put("success", false);
//				obj.put("msg", "该用户名已经注册！");
//				response.getWriter().write(new Gson().toJson(obj));
//				return;
//			}else{
//				user.setPwd(baseModel.getPwd());
//				user.setCreatetime(time.format(new Date()));
//			    int code = manager.getUserDao().insertSelective(user);
//				if(code == 1){
//					obj.put("success", true);
//					obj.put("msg", "注册成功！");
//				}else{
//					obj.put("success", false);
//					obj.put("msg", "注册失败！");
//				}
//			}
			response.getWriter().write(new Gson().toJson(obj));
			 
		}
		
		
	
}
