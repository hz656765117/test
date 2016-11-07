package com.hz.business.base.dao;

import com.hz.business.base.pojo.SignRule;
import com.hz.business.base.pojo.SignRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignRuleMapper {
    int countByExample(SignRuleExample example);

    int deleteByExample(SignRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SignRule record);

    int insertSelective(SignRule record);

    List<SignRule> selectByExample(SignRuleExample example);

    SignRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SignRule record, @Param("example") SignRuleExample example);

    int updateByExample(@Param("record") SignRule record, @Param("example") SignRuleExample example);

    int updateByPrimaryKeySelective(SignRule record);

    int updateByPrimaryKey(SignRule record);
}