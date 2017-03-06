package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblLogEmail;
import com.eshutech.biz.entity.TblLogEmailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblLogEmailMapper {
    int countByExample(TblLogEmailExample example);

    int deleteByExample(TblLogEmailExample example);

    int insert(TblLogEmail record);

    int insertSelective(TblLogEmail record);

    List<TblLogEmail> selectByExample(TblLogEmailExample example);

    int updateByExampleSelective(@Param("record") TblLogEmail record, @Param("example") TblLogEmailExample example);

    int updateByExample(@Param("record") TblLogEmail record, @Param("example") TblLogEmailExample example);
}