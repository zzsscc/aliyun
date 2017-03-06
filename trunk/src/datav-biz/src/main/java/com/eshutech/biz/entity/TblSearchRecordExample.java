package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblSearchRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblSearchRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdIsNull() {
            addCriterion("spider_topic_id is null");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdIsNotNull() {
            addCriterion("spider_topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdEqualTo(Long value) {
            addCriterion("spider_topic_id =", value, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdNotEqualTo(Long value) {
            addCriterion("spider_topic_id <>", value, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdGreaterThan(Long value) {
            addCriterion("spider_topic_id >", value, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("spider_topic_id >=", value, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdLessThan(Long value) {
            addCriterion("spider_topic_id <", value, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdLessThanOrEqualTo(Long value) {
            addCriterion("spider_topic_id <=", value, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdIn(List<Long> values) {
            addCriterion("spider_topic_id in", values, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdNotIn(List<Long> values) {
            addCriterion("spider_topic_id not in", values, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdBetween(Long value1, Long value2) {
            addCriterion("spider_topic_id between", value1, value2, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andSpiderTopicIdNotBetween(Long value1, Long value2) {
            addCriterion("spider_topic_id not between", value1, value2, "spiderTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdIsNull() {
            addCriterion("monitor_keyword_id is null");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdIsNotNull() {
            addCriterion("monitor_keyword_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdEqualTo(Long value) {
            addCriterion("monitor_keyword_id =", value, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdNotEqualTo(Long value) {
            addCriterion("monitor_keyword_id <>", value, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdGreaterThan(Long value) {
            addCriterion("monitor_keyword_id >", value, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("monitor_keyword_id >=", value, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdLessThan(Long value) {
            addCriterion("monitor_keyword_id <", value, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdLessThanOrEqualTo(Long value) {
            addCriterion("monitor_keyword_id <=", value, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdIn(List<Long> values) {
            addCriterion("monitor_keyword_id in", values, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdNotIn(List<Long> values) {
            addCriterion("monitor_keyword_id not in", values, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdBetween(Long value1, Long value2) {
            addCriterion("monitor_keyword_id between", value1, value2, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordIdNotBetween(Long value1, Long value2) {
            addCriterion("monitor_keyword_id not between", value1, value2, "monitorKeywordId");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsIsNull() {
            addCriterion("monitor_keywords is null");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsIsNotNull() {
            addCriterion("monitor_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsEqualTo(String value) {
            addCriterion("monitor_keywords =", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsNotEqualTo(String value) {
            addCriterion("monitor_keywords <>", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsGreaterThan(String value) {
            addCriterion("monitor_keywords >", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_keywords >=", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsLessThan(String value) {
            addCriterion("monitor_keywords <", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsLessThanOrEqualTo(String value) {
            addCriterion("monitor_keywords <=", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsLike(String value) {
            addCriterion("monitor_keywords like", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsNotLike(String value) {
            addCriterion("monitor_keywords not like", value, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsIn(List<String> values) {
            addCriterion("monitor_keywords in", values, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsNotIn(List<String> values) {
            addCriterion("monitor_keywords not in", values, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsBetween(String value1, String value2) {
            addCriterion("monitor_keywords between", value1, value2, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsNotBetween(String value1, String value2) {
            addCriterion("monitor_keywords not between", value1, value2, "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdIsNull() {
            addCriterion("monitor_topic_id is null");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdIsNotNull() {
            addCriterion("monitor_topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdEqualTo(Long value) {
            addCriterion("monitor_topic_id =", value, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdNotEqualTo(Long value) {
            addCriterion("monitor_topic_id <>", value, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdGreaterThan(Long value) {
            addCriterion("monitor_topic_id >", value, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("monitor_topic_id >=", value, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdLessThan(Long value) {
            addCriterion("monitor_topic_id <", value, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdLessThanOrEqualTo(Long value) {
            addCriterion("monitor_topic_id <=", value, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdIn(List<Long> values) {
            addCriterion("monitor_topic_id in", values, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdNotIn(List<Long> values) {
            addCriterion("monitor_topic_id not in", values, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdBetween(Long value1, Long value2) {
            addCriterion("monitor_topic_id between", value1, value2, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andMonitorTopicIdNotBetween(Long value1, Long value2) {
            addCriterion("monitor_topic_id not between", value1, value2, "monitorTopicId");
            return (Criteria) this;
        }

        public Criteria andFromIsNull() {
            addCriterion("from is null");
            return (Criteria) this;
        }

        public Criteria andFromIsNotNull() {
            addCriterion("from is not null");
            return (Criteria) this;
        }

        public Criteria andFromEqualTo(String value) {
            addCriterion("from =", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotEqualTo(String value) {
            addCriterion("from <>", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThan(String value) {
            addCriterion("from >", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThanOrEqualTo(String value) {
            addCriterion("from >=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThan(String value) {
            addCriterion("from <", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThanOrEqualTo(String value) {
            addCriterion("from <=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLike(String value) {
            addCriterion("from like", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotLike(String value) {
            addCriterion("from not like", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromIn(List<String> values) {
            addCriterion("from in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotIn(List<String> values) {
            addCriterion("from not in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromBetween(String value1, String value2) {
            addCriterion("from between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotBetween(String value1, String value2) {
            addCriterion("from not between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andFilterStatusIsNull() {
            addCriterion("filter_status is null");
            return (Criteria) this;
        }

        public Criteria andFilterStatusIsNotNull() {
            addCriterion("filter_status is not null");
            return (Criteria) this;
        }

        public Criteria andFilterStatusEqualTo(Integer value) {
            addCriterion("filter_status =", value, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusNotEqualTo(Integer value) {
            addCriterion("filter_status <>", value, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusGreaterThan(Integer value) {
            addCriterion("filter_status >", value, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_status >=", value, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusLessThan(Integer value) {
            addCriterion("filter_status <", value, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusLessThanOrEqualTo(Integer value) {
            addCriterion("filter_status <=", value, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusIn(List<Integer> values) {
            addCriterion("filter_status in", values, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusNotIn(List<Integer> values) {
            addCriterion("filter_status not in", values, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusBetween(Integer value1, Integer value2) {
            addCriterion("filter_status between", value1, value2, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andFilterStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_status not between", value1, value2, "filterStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(Date value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(Date value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(Date value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(Date value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(Date value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<Date> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<Date> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(Date value1, Date value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(Date value1, Date value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andWbIdIsNull() {
            addCriterion("wb_id is null");
            return (Criteria) this;
        }

        public Criteria andWbIdIsNotNull() {
            addCriterion("wb_id is not null");
            return (Criteria) this;
        }

        public Criteria andWbIdEqualTo(Long value) {
            addCriterion("wb_id =", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotEqualTo(Long value) {
            addCriterion("wb_id <>", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdGreaterThan(Long value) {
            addCriterion("wb_id >", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdGreaterThanOrEqualTo(Long value) {
            addCriterion("wb_id >=", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdLessThan(Long value) {
            addCriterion("wb_id <", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdLessThanOrEqualTo(Long value) {
            addCriterion("wb_id <=", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdIn(List<Long> values) {
            addCriterion("wb_id in", values, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotIn(List<Long> values) {
            addCriterion("wb_id not in", values, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdBetween(Long value1, Long value2) {
            addCriterion("wb_id between", value1, value2, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotBetween(Long value1, Long value2) {
            addCriterion("wb_id not between", value1, value2, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdIsNull() {
            addCriterion("wb_user_id is null");
            return (Criteria) this;
        }

        public Criteria andWbUserIdIsNotNull() {
            addCriterion("wb_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andWbUserIdEqualTo(Long value) {
            addCriterion("wb_user_id =", value, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdNotEqualTo(Long value) {
            addCriterion("wb_user_id <>", value, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdGreaterThan(Long value) {
            addCriterion("wb_user_id >", value, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("wb_user_id >=", value, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdLessThan(Long value) {
            addCriterion("wb_user_id <", value, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdLessThanOrEqualTo(Long value) {
            addCriterion("wb_user_id <=", value, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdIn(List<Long> values) {
            addCriterion("wb_user_id in", values, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdNotIn(List<Long> values) {
            addCriterion("wb_user_id not in", values, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdBetween(Long value1, Long value2) {
            addCriterion("wb_user_id between", value1, value2, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbUserIdNotBetween(Long value1, Long value2) {
            addCriterion("wb_user_id not between", value1, value2, "wbUserId");
            return (Criteria) this;
        }

        public Criteria andWbFansCountIsNull() {
            addCriterion("wb_fans_count is null");
            return (Criteria) this;
        }

        public Criteria andWbFansCountIsNotNull() {
            addCriterion("wb_fans_count is not null");
            return (Criteria) this;
        }

        public Criteria andWbFansCountEqualTo(Integer value) {
            addCriterion("wb_fans_count =", value, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountNotEqualTo(Integer value) {
            addCriterion("wb_fans_count <>", value, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountGreaterThan(Integer value) {
            addCriterion("wb_fans_count >", value, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wb_fans_count >=", value, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountLessThan(Integer value) {
            addCriterion("wb_fans_count <", value, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountLessThanOrEqualTo(Integer value) {
            addCriterion("wb_fans_count <=", value, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountIn(List<Integer> values) {
            addCriterion("wb_fans_count in", values, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountNotIn(List<Integer> values) {
            addCriterion("wb_fans_count not in", values, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountBetween(Integer value1, Integer value2) {
            addCriterion("wb_fans_count between", value1, value2, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbFansCountNotBetween(Integer value1, Integer value2) {
            addCriterion("wb_fans_count not between", value1, value2, "wbFansCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountIsNull() {
            addCriterion("wb_repost_count is null");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountIsNotNull() {
            addCriterion("wb_repost_count is not null");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountEqualTo(Integer value) {
            addCriterion("wb_repost_count =", value, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountNotEqualTo(Integer value) {
            addCriterion("wb_repost_count <>", value, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountGreaterThan(Integer value) {
            addCriterion("wb_repost_count >", value, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wb_repost_count >=", value, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountLessThan(Integer value) {
            addCriterion("wb_repost_count <", value, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountLessThanOrEqualTo(Integer value) {
            addCriterion("wb_repost_count <=", value, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountIn(List<Integer> values) {
            addCriterion("wb_repost_count in", values, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountNotIn(List<Integer> values) {
            addCriterion("wb_repost_count not in", values, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountBetween(Integer value1, Integer value2) {
            addCriterion("wb_repost_count between", value1, value2, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbRepostCountNotBetween(Integer value1, Integer value2) {
            addCriterion("wb_repost_count not between", value1, value2, "wbRepostCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountIsNull() {
            addCriterion("wb_comment_count is null");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountIsNotNull() {
            addCriterion("wb_comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountEqualTo(Integer value) {
            addCriterion("wb_comment_count =", value, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountNotEqualTo(Integer value) {
            addCriterion("wb_comment_count <>", value, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountGreaterThan(Integer value) {
            addCriterion("wb_comment_count >", value, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wb_comment_count >=", value, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountLessThan(Integer value) {
            addCriterion("wb_comment_count <", value, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("wb_comment_count <=", value, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountIn(List<Integer> values) {
            addCriterion("wb_comment_count in", values, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountNotIn(List<Integer> values) {
            addCriterion("wb_comment_count not in", values, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("wb_comment_count between", value1, value2, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("wb_comment_count not between", value1, value2, "wbCommentCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountIsNull() {
            addCriterion("wb_like_count is null");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountIsNotNull() {
            addCriterion("wb_like_count is not null");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountEqualTo(Integer value) {
            addCriterion("wb_like_count =", value, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountNotEqualTo(Integer value) {
            addCriterion("wb_like_count <>", value, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountGreaterThan(Integer value) {
            addCriterion("wb_like_count >", value, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wb_like_count >=", value, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountLessThan(Integer value) {
            addCriterion("wb_like_count <", value, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("wb_like_count <=", value, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountIn(List<Integer> values) {
            addCriterion("wb_like_count in", values, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountNotIn(List<Integer> values) {
            addCriterion("wb_like_count not in", values, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("wb_like_count between", value1, value2, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("wb_like_count not between", value1, value2, "wbLikeCount");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeIsNull() {
            addCriterion("wb_verified_type is null");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeIsNotNull() {
            addCriterion("wb_verified_type is not null");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeEqualTo(Integer value) {
            addCriterion("wb_verified_type =", value, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeNotEqualTo(Integer value) {
            addCriterion("wb_verified_type <>", value, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeGreaterThan(Integer value) {
            addCriterion("wb_verified_type >", value, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wb_verified_type >=", value, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeLessThan(Integer value) {
            addCriterion("wb_verified_type <", value, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("wb_verified_type <=", value, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeIn(List<Integer> values) {
            addCriterion("wb_verified_type in", values, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeNotIn(List<Integer> values) {
            addCriterion("wb_verified_type not in", values, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeBetween(Integer value1, Integer value2) {
            addCriterion("wb_verified_type between", value1, value2, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbVerifiedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("wb_verified_type not between", value1, value2, "wbVerifiedType");
            return (Criteria) this;
        }

        public Criteria andWbTypeIsNull() {
            addCriterion("wb_type is null");
            return (Criteria) this;
        }

        public Criteria andWbTypeIsNotNull() {
            addCriterion("wb_type is not null");
            return (Criteria) this;
        }

        public Criteria andWbTypeEqualTo(Integer value) {
            addCriterion("wb_type =", value, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeNotEqualTo(Integer value) {
            addCriterion("wb_type <>", value, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeGreaterThan(Integer value) {
            addCriterion("wb_type >", value, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wb_type >=", value, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeLessThan(Integer value) {
            addCriterion("wb_type <", value, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeLessThanOrEqualTo(Integer value) {
            addCriterion("wb_type <=", value, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeIn(List<Integer> values) {
            addCriterion("wb_type in", values, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeNotIn(List<Integer> values) {
            addCriterion("wb_type not in", values, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeBetween(Integer value1, Integer value2) {
            addCriterion("wb_type between", value1, value2, "wbType");
            return (Criteria) this;
        }

        public Criteria andWbTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("wb_type not between", value1, value2, "wbType");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyIsNull() {
            addCriterion("emotion_tendency is null");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyIsNotNull() {
            addCriterion("emotion_tendency is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyEqualTo(Integer value) {
            addCriterion("emotion_tendency =", value, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyNotEqualTo(Integer value) {
            addCriterion("emotion_tendency <>", value, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyGreaterThan(Integer value) {
            addCriterion("emotion_tendency >", value, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("emotion_tendency >=", value, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyLessThan(Integer value) {
            addCriterion("emotion_tendency <", value, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyLessThanOrEqualTo(Integer value) {
            addCriterion("emotion_tendency <=", value, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyIn(List<Integer> values) {
            addCriterion("emotion_tendency in", values, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyNotIn(List<Integer> values) {
            addCriterion("emotion_tendency not in", values, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyBetween(Integer value1, Integer value2) {
            addCriterion("emotion_tendency between", value1, value2, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionTendencyNotBetween(Integer value1, Integer value2) {
            addCriterion("emotion_tendency not between", value1, value2, "emotionTendency");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreIsNull() {
            addCriterion("emotion_score is null");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreIsNotNull() {
            addCriterion("emotion_score is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreEqualTo(Integer value) {
            addCriterion("emotion_score =", value, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreNotEqualTo(Integer value) {
            addCriterion("emotion_score <>", value, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreGreaterThan(Integer value) {
            addCriterion("emotion_score >", value, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("emotion_score >=", value, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreLessThan(Integer value) {
            addCriterion("emotion_score <", value, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreLessThanOrEqualTo(Integer value) {
            addCriterion("emotion_score <=", value, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreIn(List<Integer> values) {
            addCriterion("emotion_score in", values, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreNotIn(List<Integer> values) {
            addCriterion("emotion_score not in", values, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreBetween(Integer value1, Integer value2) {
            addCriterion("emotion_score between", value1, value2, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andEmotionScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("emotion_score not between", value1, value2, "emotionScore");
            return (Criteria) this;
        }

        public Criteria andUrlMD5IsNull() {
            addCriterion("url_m_d5 is null");
            return (Criteria) this;
        }

        public Criteria andUrlMD5IsNotNull() {
            addCriterion("url_m_d5 is not null");
            return (Criteria) this;
        }

        public Criteria andUrlMD5EqualTo(String value) {
            addCriterion("url_m_d5 =", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5NotEqualTo(String value) {
            addCriterion("url_m_d5 <>", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5GreaterThan(String value) {
            addCriterion("url_m_d5 >", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5GreaterThanOrEqualTo(String value) {
            addCriterion("url_m_d5 >=", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5LessThan(String value) {
            addCriterion("url_m_d5 <", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5LessThanOrEqualTo(String value) {
            addCriterion("url_m_d5 <=", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5Like(String value) {
            addCriterion("url_m_d5 like", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5NotLike(String value) {
            addCriterion("url_m_d5 not like", value, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5In(List<String> values) {
            addCriterion("url_m_d5 in", values, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5NotIn(List<String> values) {
            addCriterion("url_m_d5 not in", values, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5Between(String value1, String value2) {
            addCriterion("url_m_d5 between", value1, value2, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andUrlMD5NotBetween(String value1, String value2) {
            addCriterion("url_m_d5 not between", value1, value2, "urlMD5");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andLangTypeIsNull() {
            addCriterion("lang_type is null");
            return (Criteria) this;
        }

        public Criteria andLangTypeIsNotNull() {
            addCriterion("lang_type is not null");
            return (Criteria) this;
        }

        public Criteria andLangTypeEqualTo(String value) {
            addCriterion("lang_type =", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeNotEqualTo(String value) {
            addCriterion("lang_type <>", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeGreaterThan(String value) {
            addCriterion("lang_type >", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lang_type >=", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeLessThan(String value) {
            addCriterion("lang_type <", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeLessThanOrEqualTo(String value) {
            addCriterion("lang_type <=", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeLike(String value) {
            addCriterion("lang_type like", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeNotLike(String value) {
            addCriterion("lang_type not like", value, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeIn(List<String> values) {
            addCriterion("lang_type in", values, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeNotIn(List<String> values) {
            addCriterion("lang_type not in", values, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeBetween(String value1, String value2) {
            addCriterion("lang_type between", value1, value2, "langType");
            return (Criteria) this;
        }

        public Criteria andLangTypeNotBetween(String value1, String value2) {
            addCriterion("lang_type not between", value1, value2, "langType");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectIsNull() {
            addCriterion("translate_subject is null");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectIsNotNull() {
            addCriterion("translate_subject is not null");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectEqualTo(String value) {
            addCriterion("translate_subject =", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectNotEqualTo(String value) {
            addCriterion("translate_subject <>", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectGreaterThan(String value) {
            addCriterion("translate_subject >", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("translate_subject >=", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectLessThan(String value) {
            addCriterion("translate_subject <", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectLessThanOrEqualTo(String value) {
            addCriterion("translate_subject <=", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectLike(String value) {
            addCriterion("translate_subject like", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectNotLike(String value) {
            addCriterion("translate_subject not like", value, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectIn(List<String> values) {
            addCriterion("translate_subject in", values, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectNotIn(List<String> values) {
            addCriterion("translate_subject not in", values, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectBetween(String value1, String value2) {
            addCriterion("translate_subject between", value1, value2, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectNotBetween(String value1, String value2) {
            addCriterion("translate_subject not between", value1, value2, "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionIsNull() {
            addCriterion("translate_description is null");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionIsNotNull() {
            addCriterion("translate_description is not null");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionEqualTo(String value) {
            addCriterion("translate_description =", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionNotEqualTo(String value) {
            addCriterion("translate_description <>", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionGreaterThan(String value) {
            addCriterion("translate_description >", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("translate_description >=", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionLessThan(String value) {
            addCriterion("translate_description <", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionLessThanOrEqualTo(String value) {
            addCriterion("translate_description <=", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionLike(String value) {
            addCriterion("translate_description like", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionNotLike(String value) {
            addCriterion("translate_description not like", value, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionIn(List<String> values) {
            addCriterion("translate_description in", values, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionNotIn(List<String> values) {
            addCriterion("translate_description not in", values, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionBetween(String value1, String value2) {
            addCriterion("translate_description between", value1, value2, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionNotBetween(String value1, String value2) {
            addCriterion("translate_description not between", value1, value2, "translateDescription");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNull() {
            addCriterion("cluster_id is null");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNotNull() {
            addCriterion("cluster_id is not null");
            return (Criteria) this;
        }

        public Criteria andClusterIdEqualTo(Integer value) {
            addCriterion("cluster_id =", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotEqualTo(Integer value) {
            addCriterion("cluster_id <>", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThan(Integer value) {
            addCriterion("cluster_id >", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_id >=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThan(Integer value) {
            addCriterion("cluster_id <", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_id <=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdIn(List<Integer> values) {
            addCriterion("cluster_id in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotIn(List<Integer> values) {
            addCriterion("cluster_id not in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdBetween(Integer value1, Integer value2) {
            addCriterion("cluster_id between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_id not between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andMonitorKeywordsLikeInsensitive(String value) {
            addCriterion("upper(monitor_keywords) like", value.toUpperCase(), "monitorKeywords");
            return (Criteria) this;
        }

        public Criteria andFromLikeInsensitive(String value) {
            addCriterion("upper(from) like", value.toUpperCase(), "from");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(url) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andUrlMD5LikeInsensitive(String value) {
            addCriterion("upper(url_m_d5) like", value.toUpperCase(), "urlMD5");
            return (Criteria) this;
        }

        public Criteria andTagsLikeInsensitive(String value) {
            addCriterion("upper(tags) like", value.toUpperCase(), "tags");
            return (Criteria) this;
        }

        public Criteria andLangTypeLikeInsensitive(String value) {
            addCriterion("upper(lang_type) like", value.toUpperCase(), "langType");
            return (Criteria) this;
        }

        public Criteria andSubjectLikeInsensitive(String value) {
            addCriterion("upper(subject) like", value.toUpperCase(), "subject");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andTranslateSubjectLikeInsensitive(String value) {
            addCriterion("upper(translate_subject) like", value.toUpperCase(), "translateSubject");
            return (Criteria) this;
        }

        public Criteria andTranslateDescriptionLikeInsensitive(String value) {
            addCriterion("upper(translate_description) like", value.toUpperCase(), "translateDescription");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}