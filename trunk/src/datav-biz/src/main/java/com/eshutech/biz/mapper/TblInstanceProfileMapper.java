package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblInstanceProfile;
import com.eshutech.biz.entity.TblInstanceProfileExample;
import com.eshutech.biz.entity.TblInstanceProfileKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblInstanceProfileMapper {
    int countByExample(TblInstanceProfileExample example);

    int deleteByExample(TblInstanceProfileExample example);

    int deleteByPrimaryKey(TblInstanceProfileKey key);

    int insert(TblInstanceProfile record);

    int insertSelective(TblInstanceProfile record);

    List<TblInstanceProfile> selectByExample(TblInstanceProfileExample example);

    TblInstanceProfile selectByPrimaryKey(TblInstanceProfileKey key);

    int updateByExampleSelective(@Param("record") TblInstanceProfile record, @Param("example") TblInstanceProfileExample example);

    int updateByExample(@Param("record") TblInstanceProfile record, @Param("example") TblInstanceProfileExample example);

    int updateByPrimaryKeySelective(TblInstanceProfile record);

    int updateByPrimaryKey(TblInstanceProfile record);
}