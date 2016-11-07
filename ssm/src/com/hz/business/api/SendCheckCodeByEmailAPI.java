package com.hz.business.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
import com.hz.base.utils.SimpleMail;
import com.hz.business.base.model.BaseModel;
import com.hz.business.base.pojo.MailInfo;
import com.hz.business.controller.BaseController;
import com.hz.business.service.VerifyService;
/**
 * 邮箱发送验证码api
 * @author HZBOX
 * @since 2016-09-25
 */
@Controller
@RequestMapping("/mail")
public class SendCheckCodeByEmailAPI extends BaseController {
	@Resource VerifyService verifyService;
	
	//url  http://localhost:8080/checkin/sendCheckCodeByEmail.do
		@RequestMapping("/sendCheckCodeByEmail")  
		public void sendCheckCodeByEmail(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException  {
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			 
			if(StringUtils.isBlank(baseModel.getEmail())){
				obj.put("success", false);
				obj.put("msg", "邮箱不能为空！");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			 	
			MailInfo mailInfo = new MailInfo();  
	        mailInfo.setMailServerHost("smtp.163.com");  
	        mailInfo.setMailServerPort("25");  
	        mailInfo.setValidate(true);  
	        mailInfo.setUsername("ydqdsystem@163.com");  
	        mailInfo.setPassword("lufei123"); 
	        mailInfo.setFromAddress("ydqdsystem@163.com");  
	        mailInfo.setToAddress(baseModel.getEmail());  
	        mailInfo.setSubject("考勤系统用户注册验证码");  
	                  
	        //附件  
	      //  String[] attachFileNames={"e:/阅读量统计修改方案.docx"};  
	     // mailInfo.setAttachFileNames(attachFileNames);  
	          
	        // 这个类主要来发送邮件  
	        //mailInfo.setContent("设置邮箱内容");  
	        //SimpleMail.sendTextMail(mailInfo);// 发送文体格式  
	        
	        Random rad=new Random();  
	        String code  = rad.nextInt(1000000) +"";  
	        
	        mailInfo.setContent("您的验证码是："+code +"  请确认！          如不是您的验证码，请忽略此邮件");  
	        boolean result = SimpleMail.sendHtmlMail(mailInfo);// 发送html格式  
	        boolean sendstatus = false;
	        if(result){
	        	sendstatus = verifyService.insert(baseModel.getEmail() , code, Constants.VERIFY_TYPE_EMAIL);
	        }
	        
	        obj.put("success", sendstatus);
			obj.put("msg", sendstatus ? "发送成功" : "发送失败，请检查邮件是否填写正确");
			obj.put("status", sendstatus ? "1" : "2");
			response.getWriter().write(new Gson().toJson(obj));
	   
			 
		}
		
		
	
}
