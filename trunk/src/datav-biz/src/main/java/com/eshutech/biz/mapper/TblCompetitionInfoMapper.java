package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblCompetitionInfo;
import com.eshutech.biz.entity.TblCompetitionInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblCompetitionInfoMapper {
    int countByExample(TblCompetitionInfoExample example);

    int deleteByExample(TblCompetitionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblCompetitionInfo record);

    int insertSelective(TblCompetitionInfo record);

    List<TblCompetitionInfo> selectByExample(TblCompetitionInfoExample example);

    TblCompetitionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblCompetitionInfo record, @Param("example") TblCompetitionInfoExample example);

    int updateByExample(@Param("record") TblCompetitionInfo record, @Param("example") TblCompetitionInfoExample example);

    int updateByPrimaryKeySelective(TblCompetitionInfo record);

    int updateByPrimaryKey(TblCompetitionInfo record);
}