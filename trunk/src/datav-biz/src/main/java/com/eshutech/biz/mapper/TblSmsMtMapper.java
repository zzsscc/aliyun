package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblSmsMt;
import com.eshutech.biz.entity.TblSmsMtExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblSmsMtMapper {
    int countByExample(TblSmsMtExample example);

    int deleteByExample(TblSmsMtExample example);

    int insert(TblSmsMt record);

    int insertSelective(TblSmsMt record);

    List<TblSmsMt> selectByExample(TblSmsMtExample example);

    int updateByExampleSelective(@Param("record") TblSmsMt record, @Param("example") TblSmsMtExample example);

    int updateByExample(@Param("record") TblSmsMt record, @Param("example") TblSmsMtExample example);
}