package com.hz.business.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.Sign;
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
import com.hz.business.service.SignService;
import com.hz.business.service.UserService;
import com.hz.business.service.VerifyService;

/**
 * 用户签到api
 * @author HZBOX
 * @since 2016-09-27
 */
@Controller
@RequestMapping("/sys")
public class UserCheckInAPI extends BaseController {
	@Resource UserService userService;
	@Resource DaoManager manager;
	@Resource VerifyService verifyService;
	@Resource SignService signService;
	
		@RequestMapping("/userCheckIn")  
		public void userCheckIn(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
 
			
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
			
			if(StringUtils.isBlank(baseModel.getReceiveUserId())){
				obj.put("success", false);
				obj.put("msg", "接收人ID不能为空");
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
			
			if(baseModel.getLatitude() == null ){
				obj.put("success", false);
				obj.put("msg", "经度不能为空");
				obj.put("status", "6");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			if(baseModel.getLongitude() == null){
				obj.put("success", false);
				obj.put("msg", "纬度不能为空");
				obj.put("status", "7");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			 
			if(StringUtils.isBlank(baseModel.getSignAddress())){
				obj.put("success", false);
				obj.put("msg", "签到地点不能为空");
				obj.put("status", "8");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			if(StringUtils.isBlank(baseModel.getPicUrl())){
				obj.put("success", false);
				obj.put("msg", "图片路径不能为空");
				obj.put("status", "4");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			//根据签到规则和图片识别判断是否签到成功   
			
			
			Sign sign = new Sign();
			sign.setAddress(baseModel.getSignAddress());
			sign.setGroupId(baseModel.getGroupId());
			sign.setSignPersonId(baseModel.getUserId());
			sign.setLatitude(baseModel.getLatitude());
			sign.setLongitude(baseModel.getLongitude());
			sign.setSignTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
			sign.setUrl(baseModel.getPicUrl());
			sign.setReceiveId(baseModel.getReceiveUserId());
			sign.setSignPersonId(baseModel.getUserId());
			
			int result = signService.addSign(sign);
			
			if(result == 1 ){
				obj.put("success", true);
				obj.put("status", "1");
				obj.put("msg", "签到成功");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else if(result == 2){
				obj.put("success", false);
				obj.put("status", "2");
				obj.put("msg", "签到失败");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else if(result == 0){
				obj.put("success", false);
				obj.put("status", "1");
				obj.put("msg", "该小组尚未设置考勤规则");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else if(result == 9){
				obj.put("success", false);
				obj.put("status", "9");
				obj.put("msg", "不符合签到规则");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else if(result == 10){
				obj.put("success", false);
				obj.put("status", "10");
				obj.put("msg", "请先完善好个人资料，上传个人图片");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}else if(result == 11){
				obj.put("success", false);
				obj.put("status", "11");
				obj.put("msg", "人脸识别失败，请重新拍照上传");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			
			
			 
		}

	 
	
}
