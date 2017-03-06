package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblDatavTopics;
import com.eshutech.biz.entity.TblDatavTopicsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblDatavTopicsMapper {
    int countByExample(TblDatavTopicsExample example);

    int deleteByExample(TblDatavTopicsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblDatavTopics record);

    int insertSelective(TblDatavTopics record);

    List<TblDatavTopics> selectByExample(TblDatavTopicsExample example);

    TblDatavTopics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblDatavTopics record, @Param("example") TblDatavTopicsExample example);

    int updateByExample(@Param("record") TblDatavTopics record, @Param("example") TblDatavTopicsExample example);

    int updateByPrimaryKeySelective(TblDatavTopics record);

    int updateByPrimaryKey(TblDatavTopics record);

    String selectNextInstanceId(String instanceId);
}