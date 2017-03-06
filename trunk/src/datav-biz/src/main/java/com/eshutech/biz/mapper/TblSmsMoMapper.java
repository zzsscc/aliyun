package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblSmsMo;
import com.eshutech.biz.entity.TblSmsMoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblSmsMoMapper {
    int countByExample(TblSmsMoExample example);

    int deleteByExample(TblSmsMoExample example);

    int insert(TblSmsMo record);

    int insertSelective(TblSmsMo record);

    List<TblSmsMo> selectByExample(TblSmsMoExample example);

    int updateByExampleSelective(@Param("record") TblSmsMo record, @Param("example") TblSmsMoExample example);

    int updateByExample(@Param("record") TblSmsMo record, @Param("example") TblSmsMoExample example);
}