/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SystemCodeServiceImpl
 * Creator:  wanggao
 * Create-Date: 上午9:40
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.entity.TblSystemCode;
import com.eshutech.biz.entity.TblSystemCodeExample;
import com.eshutech.biz.mapper.TblSystemCodeMapper;
import com.eshutech.biz.service.SystemCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/3
 * @time: 上午9:40
 *
 */
@Service
public class SystemCodeServiceImpl implements SystemCodeService {

    @Resource
    TblSystemCodeMapper tblSystemCodeMapper;

    @Override
    public String getSystemCodeValue(String code) {
        TblSystemCodeExample tblSystemCodeExample = new TblSystemCodeExample();
        tblSystemCodeExample.createCriteria().andCodeEqualTo(code);
        List<TblSystemCode> tblSystemCodeList = tblSystemCodeMapper.selectByExample(tblSystemCodeExample);
        String value;
        if(tblSystemCodeList.isEmpty())
        {
            value = "0";
        }
        else {
            TblSystemCode tblSystemCode = tblSystemCodeList.get(0);
            value = tblSystemCode.getValue();
        }
        return value;
    }

    @Override
    public void updateSystemCode(String code, Object value) {
        TblSystemCodeExample tblSystemCodeExample = new TblSystemCodeExample();
        tblSystemCodeExample.createCriteria().andCodeEqualTo(code);
        List<TblSystemCode> tblSystemCodeList = tblSystemCodeMapper.selectByExample(tblSystemCodeExample);
        TblSystemCode tblSystemCode;
        if(!tblSystemCodeList.isEmpty())
        {
            tblSystemCode = tblSystemCodeList.get(0);
            tblSystemCode.setValue(value.toString());
            tblSystemCode.setModifyTime(new Date());
            tblSystemCodeMapper.updateByPrimaryKey(tblSystemCode);
        }
        else
        {
            tblSystemCode = new TblSystemCode();
            tblSystemCode.setName(code);
            tblSystemCode.setCode(code);
            tblSystemCode.setValue(""+value);
            tblSystemCode.setCreateTime(new Date());
            tblSystemCode.setModifyTime(new Date());
            tblSystemCodeMapper.insert(tblSystemCode);
        }
    }
}
