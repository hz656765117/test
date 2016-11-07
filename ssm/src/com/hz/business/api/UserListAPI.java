package com.hz.business.api;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.User;
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
import com.hz.business.service.UserService;
import com.hz.business.service.VerifyService;
/**
 *  获取用户列表 api
 * @author HZBOX
 * @since 2016-09-24
 */
@Controller
@RequestMapping("/sys")
public class UserListAPI extends BaseController {
	@Resource DaoManager manager;
	@Resource UserService userService;
	@Resource VerifyService verifyService;
	
	@RequestMapping("/userList")  
	public void userList(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/json;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");
	  
		List<User>	list = manager.getUserDao().selectUserByGroupId( StringUtils.isNotBlank(baseModel.getGroupId()) ? baseModel.getGroupId() : null);
		if(list !=null && list.size()>0 ){
			obj.put("success", true);
			obj.put("msg", "查询成功");
			obj.put("status", "1");
			obj.put("userList", list);
			response.getWriter().write(new Gson().toJson(obj));
			return;
		}else{
			obj.put("success", false);
			obj.put("msg", "无数据"); 
			obj.put("status", "2");
			response.getWriter().write(new Gson().toJson(obj));
			return;
		}
	}
		
		
	
}
