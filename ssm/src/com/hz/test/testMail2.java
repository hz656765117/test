package com.hz.test;

import com.hz.base.utils.SimpleMail;
import com.hz.business.base.pojo.MailInfo;

public class testMail2 {
	 public static void main(String[] args) {  
	        MailInfo mailInfo = new MailInfo();  
	        mailInfo.setMailServerHost("smtp.163.com");  
	        mailInfo.setMailServerPort("25");  
	        mailInfo.setValidate(true);  
	        mailInfo.setUsername("ydqdsystem@163.com");  
	        mailInfo.setPassword("lufei123");// 您的邮箱密码  
	        mailInfo.setFromAddress("ydqdsystem@163.com");  
	        mailInfo.setToAddress("hz656765117@163.com");  
	        mailInfo.setSubject("测试附件发送");  
	                  
	        //附件  
	        String[] attachFileNames={"e:/阅读量统计修改方案.docx"};  
	        mailInfo.setAttachFileNames(attachFileNames);  
	          
	        // 这个类主要来发送邮件  
	        //mailInfo.setContent("设置邮箱内容");  
	        //SimpleMail.sendTextMail(mailInfo);// 发送文体格式  
	        StringBuffer demo = new StringBuffer();  
	        demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")  
	        .append("<html>")  
	        .append("<head>")  
	        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")  
	        .append("<title>测试邮件</title>")  
	        .append("<style type=\"text/css\">")  
	        .append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")  
	        .append("</style>")  
	        .append("</head>")  
	        .append("<body>")  
	        .append("<span class=\"test\">大家好，这里是测试Demo</span>")  
	        .append("</body>")  
	        .append("</html>");  
	        mailInfo.setContent("我要测试一下附件发送");  
	        SimpleMail.sendHtmlMail(mailInfo);// 发送html格式  
	    }  
}
