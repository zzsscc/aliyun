package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblLogException;
import com.eshutech.biz.entity.TblLogExceptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblLogExceptionMapper {
    int countByExample(TblLogExceptionExample example);

    int deleteByExample(TblLogExceptionExample example);

    int insert(TblLogException record);

    int insertSelective(TblLogException record);

    List<TblLogException> selectByExample(TblLogExceptionExample example);

    int updateByExampleSelective(@Param("record") TblLogException record, @Param("example") TblLogExceptionExample example);

    int updateByExample(@Param("record") TblLogException record, @Param("example") TblLogExceptionExample example);
}