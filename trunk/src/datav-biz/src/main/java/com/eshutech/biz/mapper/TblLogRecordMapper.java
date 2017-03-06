package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblLogRecord;
import com.eshutech.biz.entity.TblLogRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblLogRecordMapper {
    int countByExample(TblLogRecordExample example);

    int deleteByExample(TblLogRecordExample example);

    int insert(TblLogRecord record);

    int insertSelective(TblLogRecord record);

    List<TblLogRecord> selectByExample(TblLogRecordExample example);

    int updateByExampleSelective(@Param("record") TblLogRecord record, @Param("example") TblLogRecordExample example);

    int updateByExample(@Param("record") TblLogRecord record, @Param("example") TblLogRecordExample example);
}