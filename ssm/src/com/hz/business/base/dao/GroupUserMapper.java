package com.hz.business.base.dao;

import com.hz.business.base.pojo.GroupUser;
import com.hz.business.base.pojo.GroupUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupUserMapper {
    int countByExample(GroupUserExample example);

    int deleteByExample(GroupUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupUser record);

    int insertSelective(GroupUser record);

    List<GroupUser> selectByExample(GroupUserExample example);

    GroupUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupUser record, @Param("example") GroupUserExample example);

    int updateByExample(@Param("record") GroupUser record, @Param("example") GroupUserExample example);

    int updateByPrimaryKeySelective(GroupUser record);

    int updateByPrimaryKey(GroupUser record);
}