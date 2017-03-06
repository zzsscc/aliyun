package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblSmsMtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblSmsMtExample() {
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

        public Criteria andMtTypeIsNull() {
            addCriterion("mt_type is null");
            return (Criteria) this;
        }

        public Criteria andMtTypeIsNotNull() {
            addCriterion("mt_type is not null");
            return (Criteria) this;
        }

        public Criteria andMtTypeEqualTo(String value) {
            addCriterion("mt_type =", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotEqualTo(String value) {
            addCriterion("mt_type <>", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeGreaterThan(String value) {
            addCriterion("mt_type >", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mt_type >=", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeLessThan(String value) {
            addCriterion("mt_type <", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeLessThanOrEqualTo(String value) {
            addCriterion("mt_type <=", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeLike(String value) {
            addCriterion("mt_type like", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotLike(String value) {
            addCriterion("mt_type not like", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeIn(List<String> values) {
            addCriterion("mt_type in", values, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotIn(List<String> values) {
            addCriterion("mt_type not in", values, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeBetween(String value1, String value2) {
            addCriterion("mt_type between", value1, value2, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotBetween(String value1, String value2) {
            addCriterion("mt_type not between", value1, value2, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtPhoneIsNull() {
            addCriterion("mt_phone is null");
            return (Criteria) this;
        }

        public Criteria andMtPhoneIsNotNull() {
            addCriterion("mt_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMtPhoneEqualTo(String value) {
            addCriterion("mt_phone =", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneNotEqualTo(String value) {
            addCriterion("mt_phone <>", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneGreaterThan(String value) {
            addCriterion("mt_phone >", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mt_phone >=", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneLessThan(String value) {
            addCriterion("mt_phone <", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneLessThanOrEqualTo(String value) {
            addCriterion("mt_phone <=", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneLike(String value) {
            addCriterion("mt_phone like", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneNotLike(String value) {
            addCriterion("mt_phone not like", value, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneIn(List<String> values) {
            addCriterion("mt_phone in", values, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneNotIn(List<String> values) {
            addCriterion("mt_phone not in", values, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneBetween(String value1, String value2) {
            addCriterion("mt_phone between", value1, value2, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtPhoneNotBetween(String value1, String value2) {
            addCriterion("mt_phone not between", value1, value2, "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtMsgIsNull() {
            addCriterion("mt_msg is null");
            return (Criteria) this;
        }

        public Criteria andMtMsgIsNotNull() {
            addCriterion("mt_msg is not null");
            return (Criteria) this;
        }

        public Criteria andMtMsgEqualTo(String value) {
            addCriterion("mt_msg =", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgNotEqualTo(String value) {
            addCriterion("mt_msg <>", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgGreaterThan(String value) {
            addCriterion("mt_msg >", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgGreaterThanOrEqualTo(String value) {
            addCriterion("mt_msg >=", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgLessThan(String value) {
            addCriterion("mt_msg <", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgLessThanOrEqualTo(String value) {
            addCriterion("mt_msg <=", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgLike(String value) {
            addCriterion("mt_msg like", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgNotLike(String value) {
            addCriterion("mt_msg not like", value, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgIn(List<String> values) {
            addCriterion("mt_msg in", values, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgNotIn(List<String> values) {
            addCriterion("mt_msg not in", values, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgBetween(String value1, String value2) {
            addCriterion("mt_msg between", value1, value2, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtMsgNotBetween(String value1, String value2) {
            addCriterion("mt_msg not between", value1, value2, "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtContentIsNull() {
            addCriterion("mt_content is null");
            return (Criteria) this;
        }

        public Criteria andMtContentIsNotNull() {
            addCriterion("mt_content is not null");
            return (Criteria) this;
        }

        public Criteria andMtContentEqualTo(String value) {
            addCriterion("mt_content =", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentNotEqualTo(String value) {
            addCriterion("mt_content <>", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentGreaterThan(String value) {
            addCriterion("mt_content >", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentGreaterThanOrEqualTo(String value) {
            addCriterion("mt_content >=", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentLessThan(String value) {
            addCriterion("mt_content <", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentLessThanOrEqualTo(String value) {
            addCriterion("mt_content <=", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentLike(String value) {
            addCriterion("mt_content like", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentNotLike(String value) {
            addCriterion("mt_content not like", value, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentIn(List<String> values) {
            addCriterion("mt_content in", values, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentNotIn(List<String> values) {
            addCriterion("mt_content not in", values, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentBetween(String value1, String value2) {
            addCriterion("mt_content between", value1, value2, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtContentNotBetween(String value1, String value2) {
            addCriterion("mt_content not between", value1, value2, "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtLinkidIsNull() {
            addCriterion("mt_linkid is null");
            return (Criteria) this;
        }

        public Criteria andMtLinkidIsNotNull() {
            addCriterion("mt_linkid is not null");
            return (Criteria) this;
        }

        public Criteria andMtLinkidEqualTo(String value) {
            addCriterion("mt_linkid =", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidNotEqualTo(String value) {
            addCriterion("mt_linkid <>", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidGreaterThan(String value) {
            addCriterion("mt_linkid >", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidGreaterThanOrEqualTo(String value) {
            addCriterion("mt_linkid >=", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidLessThan(String value) {
            addCriterion("mt_linkid <", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidLessThanOrEqualTo(String value) {
            addCriterion("mt_linkid <=", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidLike(String value) {
            addCriterion("mt_linkid like", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidNotLike(String value) {
            addCriterion("mt_linkid not like", value, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidIn(List<String> values) {
            addCriterion("mt_linkid in", values, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidNotIn(List<String> values) {
            addCriterion("mt_linkid not in", values, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidBetween(String value1, String value2) {
            addCriterion("mt_linkid between", value1, value2, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtLinkidNotBetween(String value1, String value2) {
            addCriterion("mt_linkid not between", value1, value2, "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtChannelIsNull() {
            addCriterion("mt_channel is null");
            return (Criteria) this;
        }

        public Criteria andMtChannelIsNotNull() {
            addCriterion("mt_channel is not null");
            return (Criteria) this;
        }

        public Criteria andMtChannelEqualTo(String value) {
            addCriterion("mt_channel =", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelNotEqualTo(String value) {
            addCriterion("mt_channel <>", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelGreaterThan(String value) {
            addCriterion("mt_channel >", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelGreaterThanOrEqualTo(String value) {
            addCriterion("mt_channel >=", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelLessThan(String value) {
            addCriterion("mt_channel <", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelLessThanOrEqualTo(String value) {
            addCriterion("mt_channel <=", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelLike(String value) {
            addCriterion("mt_channel like", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelNotLike(String value) {
            addCriterion("mt_channel not like", value, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelIn(List<String> values) {
            addCriterion("mt_channel in", values, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelNotIn(List<String> values) {
            addCriterion("mt_channel not in", values, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelBetween(String value1, String value2) {
            addCriterion("mt_channel between", value1, value2, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtChannelNotBetween(String value1, String value2) {
            addCriterion("mt_channel not between", value1, value2, "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtStatusIsNull() {
            addCriterion("mt_status is null");
            return (Criteria) this;
        }

        public Criteria andMtStatusIsNotNull() {
            addCriterion("mt_status is not null");
            return (Criteria) this;
        }

        public Criteria andMtStatusEqualTo(String value) {
            addCriterion("mt_status =", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotEqualTo(String value) {
            addCriterion("mt_status <>", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusGreaterThan(String value) {
            addCriterion("mt_status >", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mt_status >=", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusLessThan(String value) {
            addCriterion("mt_status <", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusLessThanOrEqualTo(String value) {
            addCriterion("mt_status <=", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusLike(String value) {
            addCriterion("mt_status like", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotLike(String value) {
            addCriterion("mt_status not like", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusIn(List<String> values) {
            addCriterion("mt_status in", values, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotIn(List<String> values) {
            addCriterion("mt_status not in", values, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusBetween(String value1, String value2) {
            addCriterion("mt_status between", value1, value2, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotBetween(String value1, String value2) {
            addCriterion("mt_status not between", value1, value2, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtTimeIsNull() {
            addCriterion("mt_time is null");
            return (Criteria) this;
        }

        public Criteria andMtTimeIsNotNull() {
            addCriterion("mt_time is not null");
            return (Criteria) this;
        }

        public Criteria andMtTimeEqualTo(Date value) {
            addCriterion("mt_time =", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeNotEqualTo(Date value) {
            addCriterion("mt_time <>", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeGreaterThan(Date value) {
            addCriterion("mt_time >", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mt_time >=", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeLessThan(Date value) {
            addCriterion("mt_time <", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeLessThanOrEqualTo(Date value) {
            addCriterion("mt_time <=", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeIn(List<Date> values) {
            addCriterion("mt_time in", values, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeNotIn(List<Date> values) {
            addCriterion("mt_time not in", values, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeBetween(Date value1, Date value2) {
            addCriterion("mt_time between", value1, value2, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeNotBetween(Date value1, Date value2) {
            addCriterion("mt_time not between", value1, value2, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtCountIsNull() {
            addCriterion("mt_count is null");
            return (Criteria) this;
        }

        public Criteria andMtCountIsNotNull() {
            addCriterion("mt_count is not null");
            return (Criteria) this;
        }

        public Criteria andMtCountEqualTo(String value) {
            addCriterion("mt_count =", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountNotEqualTo(String value) {
            addCriterion("mt_count <>", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountGreaterThan(String value) {
            addCriterion("mt_count >", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountGreaterThanOrEqualTo(String value) {
            addCriterion("mt_count >=", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountLessThan(String value) {
            addCriterion("mt_count <", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountLessThanOrEqualTo(String value) {
            addCriterion("mt_count <=", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountLike(String value) {
            addCriterion("mt_count like", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountNotLike(String value) {
            addCriterion("mt_count not like", value, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountIn(List<String> values) {
            addCriterion("mt_count in", values, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountNotIn(List<String> values) {
            addCriterion("mt_count not in", values, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountBetween(String value1, String value2) {
            addCriterion("mt_count between", value1, value2, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtCountNotBetween(String value1, String value2) {
            addCriterion("mt_count not between", value1, value2, "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNull() {
            addCriterion("mt_id is null");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNotNull() {
            addCriterion("mt_id is not null");
            return (Criteria) this;
        }

        public Criteria andMtIdEqualTo(String value) {
            addCriterion("mt_id =", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotEqualTo(String value) {
            addCriterion("mt_id <>", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThan(String value) {
            addCriterion("mt_id >", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThanOrEqualTo(String value) {
            addCriterion("mt_id >=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThan(String value) {
            addCriterion("mt_id <", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThanOrEqualTo(String value) {
            addCriterion("mt_id <=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLike(String value) {
            addCriterion("mt_id like", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotLike(String value) {
            addCriterion("mt_id not like", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdIn(List<String> values) {
            addCriterion("mt_id in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotIn(List<String> values) {
            addCriterion("mt_id not in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdBetween(String value1, String value2) {
            addCriterion("mt_id between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotBetween(String value1, String value2) {
            addCriterion("mt_id not between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMoStatusIsNull() {
            addCriterion("mo_status is null");
            return (Criteria) this;
        }

        public Criteria andMoStatusIsNotNull() {
            addCriterion("mo_status is not null");
            return (Criteria) this;
        }

        public Criteria andMoStatusEqualTo(String value) {
            addCriterion("mo_status =", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusNotEqualTo(String value) {
            addCriterion("mo_status <>", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusGreaterThan(String value) {
            addCriterion("mo_status >", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mo_status >=", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusLessThan(String value) {
            addCriterion("mo_status <", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusLessThanOrEqualTo(String value) {
            addCriterion("mo_status <=", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusLike(String value) {
            addCriterion("mo_status like", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusNotLike(String value) {
            addCriterion("mo_status not like", value, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusIn(List<String> values) {
            addCriterion("mo_status in", values, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusNotIn(List<String> values) {
            addCriterion("mo_status not in", values, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusBetween(String value1, String value2) {
            addCriterion("mo_status between", value1, value2, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoStatusNotBetween(String value1, String value2) {
            addCriterion("mo_status not between", value1, value2, "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoTimeIsNull() {
            addCriterion("mo_time is null");
            return (Criteria) this;
        }

        public Criteria andMoTimeIsNotNull() {
            addCriterion("mo_time is not null");
            return (Criteria) this;
        }

        public Criteria andMoTimeEqualTo(Date value) {
            addCriterion("mo_time =", value, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeNotEqualTo(Date value) {
            addCriterion("mo_time <>", value, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeGreaterThan(Date value) {
            addCriterion("mo_time >", value, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mo_time >=", value, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeLessThan(Date value) {
            addCriterion("mo_time <", value, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeLessThanOrEqualTo(Date value) {
            addCriterion("mo_time <=", value, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeIn(List<Date> values) {
            addCriterion("mo_time in", values, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeNotIn(List<Date> values) {
            addCriterion("mo_time not in", values, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeBetween(Date value1, Date value2) {
            addCriterion("mo_time between", value1, value2, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoTimeNotBetween(Date value1, Date value2) {
            addCriterion("mo_time not between", value1, value2, "moTime");
            return (Criteria) this;
        }

        public Criteria andMoIdIsNull() {
            addCriterion("mo_id is null");
            return (Criteria) this;
        }

        public Criteria andMoIdIsNotNull() {
            addCriterion("mo_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoIdEqualTo(String value) {
            addCriterion("mo_id =", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdNotEqualTo(String value) {
            addCriterion("mo_id <>", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdGreaterThan(String value) {
            addCriterion("mo_id >", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdGreaterThanOrEqualTo(String value) {
            addCriterion("mo_id >=", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdLessThan(String value) {
            addCriterion("mo_id <", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdLessThanOrEqualTo(String value) {
            addCriterion("mo_id <=", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdLike(String value) {
            addCriterion("mo_id like", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdNotLike(String value) {
            addCriterion("mo_id not like", value, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdIn(List<String> values) {
            addCriterion("mo_id in", values, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdNotIn(List<String> values) {
            addCriterion("mo_id not in", values, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdBetween(String value1, String value2) {
            addCriterion("mo_id between", value1, value2, "moId");
            return (Criteria) this;
        }

        public Criteria andMoIdNotBetween(String value1, String value2) {
            addCriterion("mo_id not between", value1, value2, "moId");
            return (Criteria) this;
        }

        public Criteria andDataDescIsNull() {
            addCriterion("data_desc is null");
            return (Criteria) this;
        }

        public Criteria andDataDescIsNotNull() {
            addCriterion("data_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDataDescEqualTo(String value) {
            addCriterion("data_desc =", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescNotEqualTo(String value) {
            addCriterion("data_desc <>", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescGreaterThan(String value) {
            addCriterion("data_desc >", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescGreaterThanOrEqualTo(String value) {
            addCriterion("data_desc >=", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescLessThan(String value) {
            addCriterion("data_desc <", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescLessThanOrEqualTo(String value) {
            addCriterion("data_desc <=", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescLike(String value) {
            addCriterion("data_desc like", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescNotLike(String value) {
            addCriterion("data_desc not like", value, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescIn(List<String> values) {
            addCriterion("data_desc in", values, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescNotIn(List<String> values) {
            addCriterion("data_desc not in", values, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescBetween(String value1, String value2) {
            addCriterion("data_desc between", value1, value2, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataDescNotBetween(String value1, String value2) {
            addCriterion("data_desc not between", value1, value2, "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(String value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(String value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(String value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(String value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(String value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(String value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLike(String value) {
            addCriterion("data_status like", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotLike(String value) {
            addCriterion("data_status not like", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<String> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<String> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(String value1, String value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(String value1, String value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
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

        public Criteria andMtTypeLikeInsensitive(String value) {
            addCriterion("upper(mt_type) like", value.toUpperCase(), "mtType");
            return (Criteria) this;
        }

        public Criteria andMtPhoneLikeInsensitive(String value) {
            addCriterion("upper(mt_phone) like", value.toUpperCase(), "mtPhone");
            return (Criteria) this;
        }

        public Criteria andMtMsgLikeInsensitive(String value) {
            addCriterion("upper(mt_msg) like", value.toUpperCase(), "mtMsg");
            return (Criteria) this;
        }

        public Criteria andMtContentLikeInsensitive(String value) {
            addCriterion("upper(mt_content) like", value.toUpperCase(), "mtContent");
            return (Criteria) this;
        }

        public Criteria andMtLinkidLikeInsensitive(String value) {
            addCriterion("upper(mt_linkid) like", value.toUpperCase(), "mtLinkid");
            return (Criteria) this;
        }

        public Criteria andMtChannelLikeInsensitive(String value) {
            addCriterion("upper(mt_channel) like", value.toUpperCase(), "mtChannel");
            return (Criteria) this;
        }

        public Criteria andMtStatusLikeInsensitive(String value) {
            addCriterion("upper(mt_status) like", value.toUpperCase(), "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtCountLikeInsensitive(String value) {
            addCriterion("upper(mt_count) like", value.toUpperCase(), "mtCount");
            return (Criteria) this;
        }

        public Criteria andMtIdLikeInsensitive(String value) {
            addCriterion("upper(mt_id) like", value.toUpperCase(), "mtId");
            return (Criteria) this;
        }

        public Criteria andMoStatusLikeInsensitive(String value) {
            addCriterion("upper(mo_status) like", value.toUpperCase(), "moStatus");
            return (Criteria) this;
        }

        public Criteria andMoIdLikeInsensitive(String value) {
            addCriterion("upper(mo_id) like", value.toUpperCase(), "moId");
            return (Criteria) this;
        }

        public Criteria andDataDescLikeInsensitive(String value) {
            addCriterion("upper(data_desc) like", value.toUpperCase(), "dataDesc");
            return (Criteria) this;
        }

        public Criteria andDataStatusLikeInsensitive(String value) {
            addCriterion("upper(data_status) like", value.toUpperCase(), "dataStatus");
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