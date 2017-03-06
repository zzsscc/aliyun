package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.entity.TblWeiboAnalysisExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblWeiboAnalysisMapper {
    int countByExample(TblWeiboAnalysisExample example);

    int deleteByExample(TblWeiboAnalysisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblWeiboAnalysis record);

    int insertSelective(TblWeiboAnalysis record);

    List<TblWeiboAnalysis> selectByExample(TblWeiboAnalysisExample example);

    TblWeiboAnalysis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblWeiboAnalysis record, @Param("example") TblWeiboAnalysisExample example);

    int updateByExample(@Param("record") TblWeiboAnalysis record, @Param("example") TblWeiboAnalysisExample example);

    int updateByPrimaryKeySelective(TblWeiboAnalysis record);

    int updateByPrimaryKey(TblWeiboAnalysis record);
}