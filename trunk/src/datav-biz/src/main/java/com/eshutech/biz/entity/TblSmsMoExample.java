package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblSmsMoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblSmsMoExample() {
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

        public Criteria andMoPhoneIsNull() {
            addCriterion("mo_phone is null");
            return (Criteria) this;
        }

        public Criteria andMoPhoneIsNotNull() {
            addCriterion("mo_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMoPhoneEqualTo(String value) {
            addCriterion("mo_phone =", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneNotEqualTo(String value) {
            addCriterion("mo_phone <>", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneGreaterThan(String value) {
            addCriterion("mo_phone >", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mo_phone >=", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneLessThan(String value) {
            addCriterion("mo_phone <", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneLessThanOrEqualTo(String value) {
            addCriterion("mo_phone <=", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneLike(String value) {
            addCriterion("mo_phone like", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneNotLike(String value) {
            addCriterion("mo_phone not like", value, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneIn(List<String> values) {
            addCriterion("mo_phone in", values, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneNotIn(List<String> values) {
            addCriterion("mo_phone not in", values, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneBetween(String value1, String value2) {
            addCriterion("mo_phone between", value1, value2, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoPhoneNotBetween(String value1, String value2) {
            addCriterion("mo_phone not between", value1, value2, "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoContentIsNull() {
            addCriterion("mo_content is null");
            return (Criteria) this;
        }

        public Criteria andMoContentIsNotNull() {
            addCriterion("mo_content is not null");
            return (Criteria) this;
        }

        public Criteria andMoContentEqualTo(String value) {
            addCriterion("mo_content =", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotEqualTo(String value) {
            addCriterion("mo_content <>", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentGreaterThan(String value) {
            addCriterion("mo_content >", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentGreaterThanOrEqualTo(String value) {
            addCriterion("mo_content >=", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLessThan(String value) {
            addCriterion("mo_content <", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLessThanOrEqualTo(String value) {
            addCriterion("mo_content <=", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLike(String value) {
            addCriterion("mo_content like", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotLike(String value) {
            addCriterion("mo_content not like", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentIn(List<String> values) {
            addCriterion("mo_content in", values, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotIn(List<String> values) {
            addCriterion("mo_content not in", values, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentBetween(String value1, String value2) {
            addCriterion("mo_content between", value1, value2, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotBetween(String value1, String value2) {
            addCriterion("mo_content not between", value1, value2, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoNumberIsNull() {
            addCriterion("mo_number is null");
            return (Criteria) this;
        }

        public Criteria andMoNumberIsNotNull() {
            addCriterion("mo_number is not null");
            return (Criteria) this;
        }

        public Criteria andMoNumberEqualTo(String value) {
            addCriterion("mo_number =", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberNotEqualTo(String value) {
            addCriterion("mo_number <>", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberGreaterThan(String value) {
            addCriterion("mo_number >", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("mo_number >=", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberLessThan(String value) {
            addCriterion("mo_number <", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberLessThanOrEqualTo(String value) {
            addCriterion("mo_number <=", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberLike(String value) {
            addCriterion("mo_number like", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberNotLike(String value) {
            addCriterion("mo_number not like", value, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberIn(List<String> values) {
            addCriterion("mo_number in", values, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberNotIn(List<String> values) {
            addCriterion("mo_number not in", values, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberBetween(String value1, String value2) {
            addCriterion("mo_number between", value1, value2, "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoNumberNotBetween(String value1, String value2) {
            addCriterion("mo_number not between", value1, value2, "moNumber");
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

        public Criteria andMoMemoIsNull() {
            addCriterion("mo_memo is null");
            return (Criteria) this;
        }

        public Criteria andMoMemoIsNotNull() {
            addCriterion("mo_memo is not null");
            return (Criteria) this;
        }

        public Criteria andMoMemoEqualTo(String value) {
            addCriterion("mo_memo =", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoNotEqualTo(String value) {
            addCriterion("mo_memo <>", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoGreaterThan(String value) {
            addCriterion("mo_memo >", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoGreaterThanOrEqualTo(String value) {
            addCriterion("mo_memo >=", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoLessThan(String value) {
            addCriterion("mo_memo <", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoLessThanOrEqualTo(String value) {
            addCriterion("mo_memo <=", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoLike(String value) {
            addCriterion("mo_memo like", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoNotLike(String value) {
            addCriterion("mo_memo not like", value, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoIn(List<String> values) {
            addCriterion("mo_memo in", values, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoNotIn(List<String> values) {
            addCriterion("mo_memo not in", values, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoBetween(String value1, String value2) {
            addCriterion("mo_memo between", value1, value2, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoMemoNotBetween(String value1, String value2) {
            addCriterion("mo_memo not between", value1, value2, "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoChannelIsNull() {
            addCriterion("mo_channel is null");
            return (Criteria) this;
        }

        public Criteria andMoChannelIsNotNull() {
            addCriterion("mo_channel is not null");
            return (Criteria) this;
        }

        public Criteria andMoChannelEqualTo(String value) {
            addCriterion("mo_channel =", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelNotEqualTo(String value) {
            addCriterion("mo_channel <>", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelGreaterThan(String value) {
            addCriterion("mo_channel >", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelGreaterThanOrEqualTo(String value) {
            addCriterion("mo_channel >=", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelLessThan(String value) {
            addCriterion("mo_channel <", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelLessThanOrEqualTo(String value) {
            addCriterion("mo_channel <=", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelLike(String value) {
            addCriterion("mo_channel like", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelNotLike(String value) {
            addCriterion("mo_channel not like", value, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelIn(List<String> values) {
            addCriterion("mo_channel in", values, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelNotIn(List<String> values) {
            addCriterion("mo_channel not in", values, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelBetween(String value1, String value2) {
            addCriterion("mo_channel between", value1, value2, "moChannel");
            return (Criteria) this;
        }

        public Criteria andMoChannelNotBetween(String value1, String value2) {
            addCriterion("mo_channel not between", value1, value2, "moChannel");
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

        public Criteria andMoPhoneLikeInsensitive(String value) {
            addCriterion("upper(mo_phone) like", value.toUpperCase(), "moPhone");
            return (Criteria) this;
        }

        public Criteria andMoContentLikeInsensitive(String value) {
            addCriterion("upper(mo_content) like", value.toUpperCase(), "moContent");
            return (Criteria) this;
        }

        public Criteria andMoNumberLikeInsensitive(String value) {
            addCriterion("upper(mo_number) like", value.toUpperCase(), "moNumber");
            return (Criteria) this;
        }

        public Criteria andMoMemoLikeInsensitive(String value) {
            addCriterion("upper(mo_memo) like", value.toUpperCase(), "moMemo");
            return (Criteria) this;
        }

        public Criteria andMoChannelLikeInsensitive(String value) {
            addCriterion("upper(mo_channel) like", value.toUpperCase(), "moChannel");
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