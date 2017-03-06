package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.AliKeyword;
import com.eshutech.biz.entity.AliKeywordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AliKeywordMapper {
    int countByExample(AliKeywordExample example);

    int deleteByExample(AliKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AliKeyword record);

    int insertSelective(AliKeyword record);

    List<AliKeyword> selectByExample(AliKeywordExample example);

    AliKeyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AliKeyword record, @Param("example") AliKeywordExample example);

    int updateByExample(@Param("record") AliKeyword record, @Param("example") AliKeywordExample example);

    int updateByPrimaryKeySelective(AliKeyword record);

    int updateByPrimaryKey(AliKeyword record);
}