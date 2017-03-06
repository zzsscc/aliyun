/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SearchJob
 * Creator:  wanggao
 * Create-Date: 下午3:18
 **/
package com.eshutech.job;

import com.alibaba.fastjson.JSON;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblSearchRecordMapper;
import com.eshutech.biz.model.aliyun.SearchResponse;
import com.eshutech.biz.service.BrandPublicSentimentService;
import com.eshutech.biz.service.SystemCodeService;
import com.eshutech.biz.task.SearchTask;
import com.eshutech.biz.util.AESDecode;
import com.eshutech.biz.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author: Kim
 * @date: 16/10/31
 * @time: 下午3:18
 *
 */
@Component
public class SearchJob {

    private static Logger logger = LoggerFactory.getLogger(SearchJob.class);

    @Resource
    BrandPublicSentimentService brandPublicSentimentService;

    @Resource
    SystemCodeService systemCodeService;

    @Resource
    TblSearchRecordMapper tblSearchRecordMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    private static boolean isRun = false;

    /**
     * 每隔一分钟执行一次
     */
//    @Scheduled(cron = "0/2 * * * * ?")
    public void realTimeSync() throws UnsupportedEncodingException {
        String search = systemCodeService.getSystemCodeValue("searchJobStatus");
        if(search.equals("0"))
        {
            return;
        }
        if(isRun)
        {
            return;
        }
        /*
         * STEP 1: 获取最后一次更新数据的时间,如果为0,则显示更新记录为当前时间
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createdAtEnd = systemCodeService.getSystemCodeValue("createdAtEnd");
        String createdAtBegin = systemCodeService.getSystemCodeValue("createdAtBegin");
        if(createdAtEnd.equals("0"))
        {
            return;
        }
        if(createdAtBegin.equals("0"))
        {
            systemCodeService.updateSystemCode("createdAtBegin","2016-10-24 00:00:00");
        }
        int pageSize = 100;
        int toPage=Integer.parseInt(systemCodeService.getSystemCodeValue("toPage"));
        if(toPage == 0)
        {
            toPage = 1;
            pageSize = 1;
        }
        isRun = true;
        String result = AESDecode.sendGet(Constants.URL+"search?pageSize="+pageSize+"&toPage="+toPage+"&createdAtBegin="+URLEncoder.encode(createdAtBegin,"utf-8")+"&createdAtEnd="+ URLEncoder.encode(createdAtEnd,"utf-8"), Constants.AK_ID, Constants.AK_SECRET);
        isRun = false;
        if(result.equals(""))
        {
            return;
        }
        SearchResponse object = JSON.parseObject(result,SearchResponse.class);
        if(object.getSuccess())
        {
            //更新记录总数
            systemCodeService.updateSystemCode("totalCount",object.getTotalCount());

            if(pageSize == 1)
            {
                toPage = 1;
                systemCodeService.updateSystemCode("toPage",toPage);
                return;
            }
            //数据排重

            //数据入库
            for(int i = 0;i<object.getResult().getRecords().size();i++)
            {
                TblSearchRecord record = object.getResult().getRecords().get(i);
                SearchTask.BI(record);
            }
            toPage ++;
            if (toPage > object.getTotalPages())
            {
                logger.info("下载完成,请修改需要下载的日期!");
                Date date = DateUtil.parseDate(createdAtEnd,"yyyy-MM-dd HH:mm:ss");
                Integer stepSeconds = Integer.parseInt(systemCodeService.getSystemCodeValue("step_seconds"));
                if(stepSeconds.equals(0))
                {
                    stepSeconds = 20;
                }
                Date nextMin = DateUtil.addSeconds(date,stepSeconds);
                //如果还是但前分钟内,继续取同一时间段内的数据,page从0开始
                if(null != nextMin && nextMin.before(new Date())) {
                    systemCodeService.updateSystemCode("createdAtBegin", createdAtEnd);
                    systemCodeService.updateSystemCode("toPage", "0");
                    systemCodeService.updateSystemCode("createdAtEnd", dateFormat.format(nextMin));
                }
                else{
                    systemCodeService.updateSystemCode("toPage", "0");
                }
            }
            else {
                systemCodeService.updateSystemCode("toPage", toPage);
            }
        }
        else{
            logger.info(result);
        }
    }
}
