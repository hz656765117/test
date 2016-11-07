package com.hz.business.base.dao;

import com.hz.business.base.pojo.Sign;
import com.hz.business.base.pojo.SignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignMapper {
    int countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignExample example);

    Sign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
    
    /**
     *  查小组内的签到
     * @param groupId 小组id
     * @param userId  签到人
     * @param type    签到成功与否  1成功 2 失败
     * @param stype 1 查小组所有的签到  2 只查用户自己的  3 只查别人指定给你的  4 查自己的签到和别人指定给你的签到
     * @return
     */
    List<Sign> selectGroupSign(@Param("groupId") String groupId , @Param("userId") String userId, @Param("type") Integer type ,@Param("stype") Integer stype );
    
}