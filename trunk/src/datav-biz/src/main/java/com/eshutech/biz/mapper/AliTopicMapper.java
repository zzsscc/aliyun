package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.AliTopic;
import com.eshutech.biz.entity.AliTopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AliTopicMapper {
    int countByExample(AliTopicExample example);

    int deleteByExample(AliTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AliTopic record);

    int insertSelective(AliTopic record);

    List<AliTopic> selectByExample(AliTopicExample example);

    AliTopic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AliTopic record, @Param("example") AliTopicExample example);

    int updateByExample(@Param("record") AliTopic record, @Param("example") AliTopicExample example);

    int updateByPrimaryKeySelective(AliTopic record);

    int updateByPrimaryKey(AliTopic record);
}