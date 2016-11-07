package com.hz.business.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hz.business.base.pojo.User;
public interface TestDao {
	List<User> queryUser();
	User queryUserByNameAndPwd(@Param("name") String name ,@Param("pwd") String pwd);
}
