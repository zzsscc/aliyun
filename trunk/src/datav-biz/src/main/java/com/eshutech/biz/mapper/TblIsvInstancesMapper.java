package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.entity.TblIsvInstancesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblIsvInstancesMapper {
    int countByExample(TblIsvInstancesExample example);

    int deleteByExample(TblIsvInstancesExample example);

    int deleteByPrimaryKey(String instanceId);

    int insert(TblIsvInstances record);

    int insertSelective(TblIsvInstances record);

    List<TblIsvInstances> selectByExample(TblIsvInstancesExample example);

    TblIsvInstances selectByPrimaryKey(String instanceId);

    int updateByExampleSelective(@Param("record") TblIsvInstances record, @Param("example") TblIsvInstancesExample example);

    int updateByExample(@Param("record") TblIsvInstances record, @Param("example") TblIsvInstancesExample example);

    int updateByPrimaryKeySelective(TblIsvInstances record);

    int updateByPrimaryKey(TblIsvInstances record);
}