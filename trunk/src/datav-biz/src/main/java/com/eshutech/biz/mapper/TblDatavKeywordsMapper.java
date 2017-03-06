package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblDatavKeywords;
import com.eshutech.biz.entity.TblDatavKeywordsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblDatavKeywordsMapper {
    int countByExample(TblDatavKeywordsExample example);

    int deleteByExample(TblDatavKeywordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblDatavKeywords record);

    int insertSelective(TblDatavKeywords record);

    List<TblDatavKeywords> selectByExample(TblDatavKeywordsExample example);

    TblDatavKeywords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblDatavKeywords record, @Param("example") TblDatavKeywordsExample example);

    int updateByExample(@Param("record") TblDatavKeywords record, @Param("example") TblDatavKeywordsExample example);

    int updateByPrimaryKeySelective(TblDatavKeywords record);

    int updateByPrimaryKey(TblDatavKeywords record);
}