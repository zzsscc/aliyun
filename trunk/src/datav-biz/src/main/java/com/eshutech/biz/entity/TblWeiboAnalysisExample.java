package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblWeiboAnalysisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblWeiboAnalysisExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInstanceidIsNull() {
            addCriterion("instanceId is null");
            return (Criteria) this;
        }

        public Criteria andInstanceidIsNotNull() {
            addCriterion("instanceId is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceidEqualTo(String value) {
            addCriterion("instanceId =", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotEqualTo(String value) {
            addCriterion("instanceId <>", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidGreaterThan(String value) {
            addCriterion("instanceId >", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidGreaterThanOrEqualTo(String value) {
            addCriterion("instanceId >=", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLessThan(String value) {
            addCriterion("instanceId <", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLessThanOrEqualTo(String value) {
            addCriterion("instanceId <=", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLike(String value) {
            addCriterion("instanceId like", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotLike(String value) {
            addCriterion("instanceId not like", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidIn(List<String> values) {
            addCriterion("instanceId in", values, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotIn(List<String> values) {
            addCriterion("instanceId not in", values, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidBetween(String value1, String value2) {
            addCriterion("instanceId between", value1, value2, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotBetween(String value1, String value2) {
            addCriterion("instanceId not between", value1, value2, "instanceid");
            return (Criteria) this;
        }

        public Criteria andWeiboUserIsNull() {
            addCriterion("weibo_user is null");
            return (Criteria) this;
        }

        public Criteria andWeiboUserIsNotNull() {
            addCriterion("weibo_user is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboUserEqualTo(String value) {
            addCriterion("weibo_user =", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserNotEqualTo(String value) {
            addCriterion("weibo_user <>", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserGreaterThan(String value) {
            addCriterion("weibo_user >", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_user >=", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserLessThan(String value) {
            addCriterion("weibo_user <", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserLessThanOrEqualTo(String value) {
            addCriterion("weibo_user <=", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserLike(String value) {
            addCriterion("weibo_user like", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserNotLike(String value) {
            addCriterion("weibo_user not like", value, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserIn(List<String> values) {
            addCriterion("weibo_user in", values, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserNotIn(List<String> values) {
            addCriterion("weibo_user not in", values, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserBetween(String value1, String value2) {
            addCriterion("weibo_user between", value1, value2, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboUserNotBetween(String value1, String value2) {
            addCriterion("weibo_user not between", value1, value2, "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboDescIsNull() {
            addCriterion("weibo_desc is null");
            return (Criteria) this;
        }

        public Criteria andWeiboDescIsNotNull() {
            addCriterion("weibo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboDescEqualTo(String value) {
            addCriterion("weibo_desc =", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescNotEqualTo(String value) {
            addCriterion("weibo_desc <>", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescGreaterThan(String value) {
            addCriterion("weibo_desc >", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_desc >=", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescLessThan(String value) {
            addCriterion("weibo_desc <", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescLessThanOrEqualTo(String value) {
            addCriterion("weibo_desc <=", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescLike(String value) {
            addCriterion("weibo_desc like", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescNotLike(String value) {
            addCriterion("weibo_desc not like", value, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescIn(List<String> values) {
            addCriterion("weibo_desc in", values, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescNotIn(List<String> values) {
            addCriterion("weibo_desc not in", values, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescBetween(String value1, String value2) {
            addCriterion("weibo_desc between", value1, value2, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboDescNotBetween(String value1, String value2) {
            addCriterion("weibo_desc not between", value1, value2, "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlIsNull() {
            addCriterion("weibo_url is null");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlIsNotNull() {
            addCriterion("weibo_url is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlEqualTo(String value) {
            addCriterion("weibo_url =", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlNotEqualTo(String value) {
            addCriterion("weibo_url <>", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlGreaterThan(String value) {
            addCriterion("weibo_url >", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_url >=", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlLessThan(String value) {
            addCriterion("weibo_url <", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlLessThanOrEqualTo(String value) {
            addCriterion("weibo_url <=", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlLike(String value) {
            addCriterion("weibo_url like", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlNotLike(String value) {
            addCriterion("weibo_url not like", value, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlIn(List<String> values) {
            addCriterion("weibo_url in", values, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlNotIn(List<String> values) {
            addCriterion("weibo_url not in", values, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlBetween(String value1, String value2) {
            addCriterion("weibo_url between", value1, value2, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlNotBetween(String value1, String value2) {
            addCriterion("weibo_url not between", value1, value2, "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Integer value) {
            addCriterion("show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Integer value) {
            addCriterion("show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Integer value) {
            addCriterion("show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Integer value) {
            addCriterion("show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Integer value) {
            addCriterion("show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Integer> values) {
            addCriterion("show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Integer> values) {
            addCriterion("show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Integer value1, Integer value2) {
            addCriterion("show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNull() {
            addCriterion("analysis_id is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNotNull() {
            addCriterion("analysis_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdEqualTo(String value) {
            addCriterion("analysis_id =", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotEqualTo(String value) {
            addCriterion("analysis_id <>", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThan(String value) {
            addCriterion("analysis_id >", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThanOrEqualTo(String value) {
            addCriterion("analysis_id >=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThan(String value) {
            addCriterion("analysis_id <", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThanOrEqualTo(String value) {
            addCriterion("analysis_id <=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLike(String value) {
            addCriterion("analysis_id like", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotLike(String value) {
            addCriterion("analysis_id not like", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIn(List<String> values) {
            addCriterion("analysis_id in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotIn(List<String> values) {
            addCriterion("analysis_id not in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdBetween(String value1, String value2) {
            addCriterion("analysis_id between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotBetween(String value1, String value2) {
            addCriterion("analysis_id not between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdIsNull() {
            addCriterion("analysis_result_id is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdIsNotNull() {
            addCriterion("analysis_result_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdEqualTo(String value) {
            addCriterion("analysis_result_id =", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdNotEqualTo(String value) {
            addCriterion("analysis_result_id <>", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdGreaterThan(String value) {
            addCriterion("analysis_result_id >", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdGreaterThanOrEqualTo(String value) {
            addCriterion("analysis_result_id >=", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdLessThan(String value) {
            addCriterion("analysis_result_id <", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdLessThanOrEqualTo(String value) {
            addCriterion("analysis_result_id <=", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdLike(String value) {
            addCriterion("analysis_result_id like", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdNotLike(String value) {
            addCriterion("analysis_result_id not like", value, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdIn(List<String> values) {
            addCriterion("analysis_result_id in", values, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdNotIn(List<String> values) {
            addCriterion("analysis_result_id not in", values, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdBetween(String value1, String value2) {
            addCriterion("analysis_result_id between", value1, value2, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdNotBetween(String value1, String value2) {
            addCriterion("analysis_result_id not between", value1, value2, "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgIsNull() {
            addCriterion("weibo_head_img is null");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgIsNotNull() {
            addCriterion("weibo_head_img is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgEqualTo(String value) {
            addCriterion("weibo_head_img =", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgNotEqualTo(String value) {
            addCriterion("weibo_head_img <>", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgGreaterThan(String value) {
            addCriterion("weibo_head_img >", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_head_img >=", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgLessThan(String value) {
            addCriterion("weibo_head_img <", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgLessThanOrEqualTo(String value) {
            addCriterion("weibo_head_img <=", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgLike(String value) {
            addCriterion("weibo_head_img like", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgNotLike(String value) {
            addCriterion("weibo_head_img not like", value, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgIn(List<String> values) {
            addCriterion("weibo_head_img in", values, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgNotIn(List<String> values) {
            addCriterion("weibo_head_img not in", values, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgBetween(String value1, String value2) {
            addCriterion("weibo_head_img between", value1, value2, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgNotBetween(String value1, String value2) {
            addCriterion("weibo_head_img not between", value1, value2, "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeIsNull() {
            addCriterion("weibo_create_time is null");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeIsNotNull() {
            addCriterion("weibo_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeEqualTo(String value) {
            addCriterion("weibo_create_time =", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeNotEqualTo(String value) {
            addCriterion("weibo_create_time <>", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeGreaterThan(String value) {
            addCriterion("weibo_create_time >", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_create_time >=", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeLessThan(String value) {
            addCriterion("weibo_create_time <", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("weibo_create_time <=", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeLike(String value) {
            addCriterion("weibo_create_time like", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeNotLike(String value) {
            addCriterion("weibo_create_time not like", value, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeIn(List<String> values) {
            addCriterion("weibo_create_time in", values, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeNotIn(List<String> values) {
            addCriterion("weibo_create_time not in", values, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeBetween(String value1, String value2) {
            addCriterion("weibo_create_time between", value1, value2, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeNotBetween(String value1, String value2) {
            addCriterion("weibo_create_time not between", value1, value2, "weiboCreateTime");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIsNull() {
            addCriterion("reposts_count is null");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIsNotNull() {
            addCriterion("reposts_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepostsCountEqualTo(Integer value) {
            addCriterion("reposts_count =", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotEqualTo(Integer value) {
            addCriterion("reposts_count <>", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountGreaterThan(Integer value) {
            addCriterion("reposts_count >", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reposts_count >=", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLessThan(Integer value) {
            addCriterion("reposts_count <", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLessThanOrEqualTo(Integer value) {
            addCriterion("reposts_count <=", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIn(List<Integer> values) {
            addCriterion("reposts_count in", values, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotIn(List<Integer> values) {
            addCriterion("reposts_count not in", values, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountBetween(Integer value1, Integer value2) {
            addCriterion("reposts_count between", value1, value2, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reposts_count not between", value1, value2, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andInstanceidLikeInsensitive(String value) {
            addCriterion("upper(instanceId) like", value.toUpperCase(), "instanceid");
            return (Criteria) this;
        }

        public Criteria andWeiboUserLikeInsensitive(String value) {
            addCriterion("upper(weibo_user) like", value.toUpperCase(), "weiboUser");
            return (Criteria) this;
        }

        public Criteria andWeiboDescLikeInsensitive(String value) {
            addCriterion("upper(weibo_desc) like", value.toUpperCase(), "weiboDesc");
            return (Criteria) this;
        }

        public Criteria andWeiboUrlLikeInsensitive(String value) {
            addCriterion("upper(weibo_url) like", value.toUpperCase(), "weiboUrl");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLikeInsensitive(String value) {
            addCriterion("upper(analysis_id) like", value.toUpperCase(), "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisResultIdLikeInsensitive(String value) {
            addCriterion("upper(analysis_result_id) like", value.toUpperCase(), "analysisResultId");
            return (Criteria) this;
        }

        public Criteria andWeiboHeadImgLikeInsensitive(String value) {
            addCriterion("upper(weibo_head_img) like", value.toUpperCase(), "weiboHeadImg");
            return (Criteria) this;
        }

        public Criteria andWeiboCreateTimeLikeInsensitive(String value) {
            addCriterion("upper(weibo_create_time) like", value.toUpperCase(), "weiboCreateTime");
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