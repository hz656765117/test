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
import com.hz.business.base.pojo.Group;
import com.hz.business.base.pojo.GroupExample;
import com.hz.business.base.pojo.GroupUser;
import com.hz.business.controller.BaseController;
 

/**
 * 创建小组api
 * @author HZBOX
 * @since 2016-09-27
 */
@Controller
@RequestMapping("/sys")
public class CreateGroupAPI extends BaseController {
//	@Resource UserService userService;
//	@Resource DaoManager manager;
//	@Resource VerifyService verifyService;
//	@Resource SignService signService;
//	@Resource GroupService groupService;
	
		@RequestMapping("/createGroup")  
		public void createGroup(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			 
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			
			if(StringUtils.isBlank(baseModel.getUserId())){
				obj.put("success", false);
				obj.put("msg", "用户ID不能为空");
				obj.put("status", "3");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
		 
			if(StringUtils.isBlank(baseModel.getGroupName())){
				obj.put("success", false);
				obj.put("msg", "小组名称不能为空");
				obj.put("status", "4");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			 
			if(StringUtils.isBlank(baseModel.getGroupUsers())){
				obj.put("success", false);
				obj.put("msg", "小组成员不能为空");
				obj.put("status", "5");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			GroupExample example = new GroupExample();
			example.createCriteria().andNameEqualTo( baseModel.getGroupName()).andStatusEqualTo(Constants.GROUP_STATUS_VALID);
			List<Group> list = manager.getGroupMapper().selectByExample(example);
			if(list != null && list.size()>0){
				obj.put("success", false);
				obj.put("msg", "小组名称已存在");
				obj.put("status", "6");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			Group group =  groupService.createGroup(baseModel.getUserId(), baseModel.getGroupName(), baseModel.getGroupUsers(), baseModel.getGroupDesc() );
			 
			if(group != null ){
				obj.put("success", true);
				obj.put("status", "1");
				obj.put("msg", "创建成功");
				obj.put("group", group);
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else{
				obj.put("success", false);
				obj.put("status", "1");
				obj.put("msg", "创建失败");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			} 
		}
		
		/**
		 * 删除群组
		 * @param request
		 * @param response
		 * @param baseModel
		 * @param model
		 * @throws IOException
		 */
		@RequestMapping("/delGroup")  
		public void delGroup(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			boolean success = groupService.delGroup(baseModel.getGroupId());
			JSONObject obj = new JSONObject();
			if(success){
				obj.put("success", true);
				obj.put("msg", "删除成功");
				obj.put("status", "1");
				responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "删除失败");
				obj.put("status", "2");
				responseObj(obj);
			}
		}
		 
		
		/**
		 * 添加群成员
		 * @param request
		 * @param response
		 * @param baseModel
		 * @param model
		 * @throws IOException
		 */
		@RequestMapping("/addUser")  
		public void addUser(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			List<GroupUser> list = groupUserService.addGroupUser(baseModel.getGroupId(), baseModel.getGroupUsers());
			JSONObject obj = new JSONObject();
			if(list != null && list.size()>0){
				obj.put("success", true);
				obj.put("msg", "添加成员成功");
				obj.put("status", "1");
				obj.put("list", list);
				boolean success = responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "没有添加成员");
				obj.put("status", "2");
				boolean success = responseObj(obj);
			}
		}
		
		/**
		 * 删除群成员
		 * @param request
		 * @param response
		 * @param baseModel
		 * @param model
		 * @throws IOException
		 */
		@RequestMapping("/delUser")  
		public void delUser(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			boolean success = groupUserService.delGroupUser(baseModel.getGroupId(), baseModel.getGroupUsers());
			JSONObject obj = new JSONObject();
			if(success){
				obj.put("success", true);
				obj.put("msg", "删除成员成功");
				obj.put("status", "1");
				responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "删除成员失败");
				obj.put("status", "2");
				responseObj(obj);
			}
		}
		/**
		 * 查询群组的所有人员
		 * @param request
		 * @param response
		 * @param baseModel
		 * @param model
		 * @throws IOException
		 */
		@RequestMapping("/getGroupAllUser")  
		public void getGroupAllUser(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			List<GroupUser> list = groupUserService.listGroupUser(baseModel.getGroupId());
			JSONObject obj = new JSONObject();
			if(list != null && list.size()>0){
				obj.put("success", true);
				obj.put("msg", "查询成员成功");
				obj.put("status", "1");
				obj.put("list", list);
				responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "没有查到成员");
				obj.put("status", "2");
				responseObj(obj);
			}
		}
		
		
		
			

	 
	
}
