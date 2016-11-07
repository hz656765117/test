package com.hz.test;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.hz.base.utils.MailUtil;
import com.hz.business.base.pojo.Mail;

public class TestMail {
	
	
	public static void main(String[] args) throws AddressException, MessagingException {  
        Mail mail = new Mail();  
        mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
        mail.setSender("ydqdsystem@163.com");  
        mail.setReceiver("chenlufei713@foxmail.com"); // 接收人  
        mail.setUsername("ydqdsystem@163.com"); // 登录账号,一般都是和邮箱名一样吧  
        mail.setPassword("lufei123"); // 发件人邮箱的登录密码  
        mail.setSubject("测试javamail邮件是否正常发送");  
        mail.setMessage("您的验证码是:123456");  
        MailUtil.send(mail);
       
    }  
	
}
