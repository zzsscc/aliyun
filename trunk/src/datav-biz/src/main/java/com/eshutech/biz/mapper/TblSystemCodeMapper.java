package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblSystemCode;
import com.eshutech.biz.entity.TblSystemCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblSystemCodeMapper {
    int countByExample(TblSystemCodeExample example);

    int deleteByExample(TblSystemCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblSystemCode record);

    int insertSelective(TblSystemCode record);

    List<TblSystemCode> selectByExample(TblSystemCodeExample example);

    TblSystemCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblSystemCode record, @Param("example") TblSystemCodeExample example);

    int updateByExample(@Param("record") TblSystemCode record, @Param("example") TblSystemCodeExample example);

    int updateByPrimaryKeySelective(TblSystemCode record);

    int updateByPrimaryKey(TblSystemCode record);
}