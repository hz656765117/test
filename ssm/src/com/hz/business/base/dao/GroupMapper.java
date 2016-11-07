package com.hz.business.base.dao;

import com.hz.business.base.pojo.Group;
import com.hz.business.base.pojo.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    int countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
    
    /**
     * 根据用户id查小组
     * type  0 查用户存在的所有小组  1 查用户是群主的小组  2 查用户是群员的小组  不包括群主
     * @param userId
     * @param type
     * @return
     */
    List<Group> selectGroupListByUserId(@Param("userId") String userId , @Param("type") Integer type);
}