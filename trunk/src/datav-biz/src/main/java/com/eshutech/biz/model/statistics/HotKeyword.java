/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: HotKeyword
 * Creator:  wanggao
 * Create-Date: 上午11:27
 **/
package com.eshutech.biz.model.statistics;

/**
 *
 * @author: Kim
 * @date: 16/11/25
 * @time: 上午11:27
 *
 */
public class HotKeyword {
    private String keyword;
    private String sentimentCount;
    private String keywordId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSentimentCount() {
        return sentimentCount;
    }

    public void setSentimentCount(String sentimentCount) {
        this.sentimentCount = sentimentCount;
    }

    public String getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(String keywordId) {
        this.keywordId = keywordId;
    }


}
