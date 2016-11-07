package com.hz.business.base.model;

import com.hz.business.base.pojo.SignRule;
import com.hz.business.base.pojo.User;

public class BaseModel {
	private User user;
 
	private Long curModifyId;
	private Long curOperateId;
	private String user_login_name;
	private String user_login_pwd;
	private String auth_code;
	private String tel;
	private String email;
	private String old_login_pwd;
	private String new_login_pwd;
	private int type;           //类型
	private String time;        //时间
	private String userId;     //用户id
	private String groupId;     //小组id
	private String signAddress; //签到地点名称
	private String picUrl;   //图片url
    private Double latitude; //经度
    private Double longitude;//纬度
    private String receiveUserId;//接收人id
    private String groupName; //小组名称
    private String groupDesc;//小组描述
    private String groupUsers;//小组成员  用-分割开   111-222-333
    private String searchId;// 用户id 用于查询
    private int status;//状态
    private String picStr;//图片流 base64加密字节数组
    private String picName;//图片名字
    private int gender ; //性别
    private String stuNo;//学号
    private String school;//学校
    
    private String signCycle;//签到周期
    private String startTime;//签入时间
    private String endTime;//签出时间
    private String address;//地址
    private int prec;//精度（米）
    
    private String ruleName;//签到规则名
    
    
 
    
    
 
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getCurModifyId() {
		return curModifyId;
	}
	public void setCurModifyId(Long curModifyId) {
		this.curModifyId = curModifyId;
	}
	public Long getCurOperateId() {
		return curOperateId;
	}
	public void setCurOperateId(Long curOperateId) {
		this.curOperateId = curOperateId;
	}
	public String getUser_login_name() {
		return user_login_name;
	}
	public void setUser_login_name(String user_login_name) {
		this.user_login_name = user_login_name;
	}
	public String getUser_login_pwd() {
		return user_login_pwd;
	}
	public void setUser_login_pwd(String user_login_pwd) {
		this.user_login_pwd = user_login_pwd;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOld_login_pwd() {
		return old_login_pwd;
	}
	public void setOld_login_pwd(String old_login_pwd) {
		this.old_login_pwd = old_login_pwd;
	}
	public String getNew_login_pwd() {
		return new_login_pwd;
	}
	public void setNew_login_pwd(String new_login_pwd) {
		this.new_login_pwd = new_login_pwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSignAddress() {
		return signAddress;
	}
	public void setSignAddress(String signAddress) {
		this.signAddress = signAddress;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public String getGroupUsers() {
		return groupUsers;
	}
	public void setGroupUsers(String groupUsers) {
		this.groupUsers = groupUsers;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPicStr() {
		return picStr;
	}
	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSignCycle() {
		return signCycle;
	}
	public void setSignCycle(String signCycle) {
		this.signCycle = signCycle;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrec() {
		return prec;
	}
	public void setPrec(int prec) {
		this.prec = prec;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
 
}
