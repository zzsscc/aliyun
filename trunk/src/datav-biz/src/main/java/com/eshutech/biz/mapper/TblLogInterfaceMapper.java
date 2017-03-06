package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblLogInterface;
import com.eshutech.biz.entity.TblLogInterfaceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblLogInterfaceMapper {
    int countByExample(TblLogInterfaceExample example);

    int deleteByExample(TblLogInterfaceExample example);

    int insert(TblLogInterface record);

    int insertSelective(TblLogInterface record);

    List<TblLogInterface> selectByExample(TblLogInterfaceExample example);

    int updateByExampleSelective(@Param("record") TblLogInterface record, @Param("example") TblLogInterfaceExample example);

    int updateByExample(@Param("record") TblLogInterface record, @Param("example") TblLogInterfaceExample example);
}