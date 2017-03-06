package com.eshutech.biz.mapper;

import com.eshutech.biz.entity.TblUser;
import com.eshutech.biz.entity.TblUserExample;
import com.eshutech.biz.model.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblUserMapper {
    int countByExample(TblUserExample example);

    int deleteByExample(TblUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    List<TblUser> selectByExample(TblUserExample example);

    TblUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByExample(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);

    List<UserVo> selectUserVo(TblUserExample example);

    int countVoByExample(TblUserExample example);
}