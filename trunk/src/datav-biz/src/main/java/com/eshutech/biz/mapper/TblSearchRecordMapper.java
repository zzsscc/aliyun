package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.entity.TblSearchRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblSearchRecordMapper {
    int countByExample(TblSearchRecordExample example);

    int deleteByExample(TblSearchRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblSearchRecord record);

    int batchInsert(List<TblSearchRecord> records);

    int insertSelective(TblSearchRecord record);

    List<TblSearchRecord> selectByExample(TblSearchRecordExample example);

    TblSearchRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblSearchRecord record, @Param("example") TblSearchRecordExample example);

    int updateByExample(@Param("record") TblSearchRecord record, @Param("example") TblSearchRecordExample example);

    int updateByPrimaryKeySelective(TblSearchRecord record);

    int updateByPrimaryKey(TblSearchRecord record);
}