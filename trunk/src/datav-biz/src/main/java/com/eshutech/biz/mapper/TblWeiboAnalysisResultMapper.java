package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblWeiboAnalysisResult;
import com.eshutech.biz.entity.TblWeiboAnalysisResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblWeiboAnalysisResultMapper {
    int countByExample(TblWeiboAnalysisResultExample example);

    int deleteByExample(TblWeiboAnalysisResultExample example);

    int deleteByPrimaryKey(String id);

    int insert(TblWeiboAnalysisResult record);

    int insertSelective(TblWeiboAnalysisResult record);

    List<TblWeiboAnalysisResult> selectByExampleWithBLOBs(TblWeiboAnalysisResultExample example);

    List<TblWeiboAnalysisResult> selectByExample(TblWeiboAnalysisResultExample example);

    TblWeiboAnalysisResult selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TblWeiboAnalysisResult record, @Param("example") TblWeiboAnalysisResultExample example);

    int updateByExampleWithBLOBs(@Param("record") TblWeiboAnalysisResult record, @Param("example") TblWeiboAnalysisResultExample example);

    int updateByExample(@Param("record") TblWeiboAnalysisResult record, @Param("example") TblWeiboAnalysisResultExample example);

    int updateByPrimaryKeySelective(TblWeiboAnalysisResult record);

    int updateByPrimaryKeyWithBLOBs(TblWeiboAnalysisResult record);

    int updateByPrimaryKey(TblWeiboAnalysisResult record);
}