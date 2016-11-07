package com.hz.business.service;


/**
 * 验证码service层接口
 * @author HZBOX
 * @since 2016-09-25
 */
public interface VerifyService {
	/**
	 * 新增验证码
	 * @param name 邮箱或电话
	 * @param code 验证码
	 * @param type 类型 1为邮箱 2为手机
	 * @return
	 */
	boolean insert(String name , String code ,int type);
	
	/**
	 * 校验验证码是否正确
	 * @param name 邮箱或电话
	 * @param type 类型 1为邮箱 2为手机
	 * @param code 验证码
	 * @return
	 */
	boolean validCode(String name , String type ,String code);
}
