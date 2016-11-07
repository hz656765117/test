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
import com.hz.business.base.pojo.SignRule;
import com.hz.business.controller.BaseController;
 

/**
 * 添加签到规则api
 * @author HZBOX
 * @since 2016-09-27
 */
@Controller
@RequestMapping("/signrule")
public class CreateSignRuleAPI extends BaseController {
		
	
		//http://localhost:8080/ssm/signrule/addSignRule.do?groupId=1&userId=10&signCycle=1,2,3,4,5&startTime=8:30&endTime=17:30&address=%E6%96%87%E4%B8%80%E8%B7%AF&prec=100&latitude=120.120982&longitude=30.296659
		@RequestMapping("/addSignRule")  
		public void addSignRule(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			 
			
			JSONObject obj = new JSONObject();
			
			/*if(StringUtils.isBlank(baseModel.getUserId())){
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
			}*/
			SignRule signRule = new SignRule();
			signRule.setCreatePerson(baseModel.getUserId());
			signRule.setGroupId(baseModel.getGroupId());
			signRule.setSignCycle(baseModel.getSignCycle());
			signRule.setStartTime(baseModel.getStartTime());
			signRule.setEndTime(baseModel.getEndTime());
			signRule.setLatitude(baseModel.getLatitude());
			signRule.setLongitude(baseModel.getLatitude());
			signRule.setAddress(baseModel.getAddress());
			signRule.setPrec(baseModel.getPrec());
			signRule.setName(baseModel.getRuleName());
			SignRule result = signRuleService.addSignRule(signRule);
			
			if(result != null ){
				obj.put("success", true);
				obj.put("msg", "添加签到规则成功");
				obj.put("status", "1");
				obj.put("signrule", result);
				super.responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "添加签到规则失败");
				obj.put("status", "2");
				super.responseObj(obj);
			}
			 
		}
	 
		
		
		 
		/**
		 * 删除签到规则
		 * @param request
		 * @param response
		 * @param baseModel
		 * @param model
		 * @throws IOException
		 */
		@RequestMapping("/delSignRule")  
		public void delSignRule(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			JSONObject obj = new JSONObject();
			boolean success = signRuleService.delSignRule(baseModel.getGroupId()); 
			if(success ){
				obj.put("success", true);
				obj.put("msg", "删除成功");
				obj.put("status", "1");
				super.responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "删除失败");
				obj.put("status", "2");
				super.responseObj(obj);
			}
		}
		/**
		 * 修改签到规则
		 * @param request
		 * @param response
		 * @param baseModel
		 * @param model
		 * @throws IOException
		 */
		@RequestMapping("/updateSignRule")  
		public void updateSignRule(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			JSONObject obj = new JSONObject();
			 
			SignRule signRule = new SignRule();
			signRule.setCreatePerson(baseModel.getUserId());
			signRule.setGroupId(baseModel.getGroupId());
			signRule.setSignCycle(baseModel.getSignCycle());
			signRule.setStartTime(baseModel.getStartTime());
			signRule.setEndTime(baseModel.getEndTime());
			signRule.setLatitude(baseModel.getLatitude());
			signRule.setLongitude(baseModel.getLatitude());
			signRule.setAddress(baseModel.getAddress());
			signRule.setPrec(baseModel.getPrec());
			signRule.setName(baseModel.getRuleName());
			SignRule result = signRuleService.addSignRule(signRule);
			
			if(result != null ){
				obj.put("success", true);
				obj.put("msg", "添加签到规则成功");
				obj.put("status", "1");
				obj.put("signrule", result);
				super.responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "添加签到规则失败");
				obj.put("status", "2");
				super.responseObj(obj);
			}
		}
			

		@RequestMapping("/listSignRule")  
		public void listSignRule(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			JSONObject obj = new JSONObject();
			List<SignRule> signRules = signRuleService.listSignRule(baseModel.getGroupId()); 
			if(signRules != null && signRules.size()>0 ){
				obj.put("success", true);
				obj.put("msg", "查询成功");
				obj.put("signRules", signRules);
				obj.put("status", "1");
				super.responseObj(obj);
			}else{
				obj.put("success", false);
				obj.put("msg", "查询失败");
				obj.put("status", "2");
				super.responseObj(obj);
			}
		}
	
}
