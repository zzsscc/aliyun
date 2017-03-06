package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblLogOperation;
import com.eshutech.biz.entity.TblLogOperationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblLogOperationMapper {
    int countByExample(TblLogOperationExample example);

    int deleteByExample(TblLogOperationExample example);

    int insert(TblLogOperation record);

    int insertSelective(TblLogOperation record);

    List<TblLogOperation> selectByExample(TblLogOperationExample example);

    int updateByExampleSelective(@Param("record") TblLogOperation record, @Param("example") TblLogOperationExample example);

    int updateByExample(@Param("record") TblLogOperation record, @Param("example") TblLogOperationExample example);
}