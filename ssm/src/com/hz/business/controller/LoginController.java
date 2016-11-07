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

import com.google.gson.Gson;
import com.hz.base.Constants;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.Group;
import com.hz.business.base.pojo.GroupExample;
import com.hz.business.controller.BaseController;
import com.hz.business.service.DaoManager;
import com.hz.business.service.GroupService;
import com.hz.business.service.SignService;
import com.hz.business.service.UserService;
import com.hz.business.service.VerifyService;

/**
 * 创建小组api
 * @author HZBOX
 * @since 2016-09-27
 */
@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController {
	@Resource UserService userService;
	@Resource DaoManager manager;
	@Resource VerifyService verifyService;
	@Resource SignService signService;
	@Resource GroupService groupService;
	
	@RequestMapping("/doLogin")  
	public String doLogin(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
		return "index";
	}
			

	 
	
}
