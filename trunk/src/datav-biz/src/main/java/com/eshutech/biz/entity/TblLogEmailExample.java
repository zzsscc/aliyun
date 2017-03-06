package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblLogEmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblLogEmailExample() {
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

        public Criteria andEmailFromIsNull() {
            addCriterion("email_from is null");
            return (Criteria) this;
        }

        public Criteria andEmailFromIsNotNull() {
            addCriterion("email_from is not null");
            return (Criteria) this;
        }

        public Criteria andEmailFromEqualTo(String value) {
            addCriterion("email_from =", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromNotEqualTo(String value) {
            addCriterion("email_from <>", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromGreaterThan(String value) {
            addCriterion("email_from >", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromGreaterThanOrEqualTo(String value) {
            addCriterion("email_from >=", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromLessThan(String value) {
            addCriterion("email_from <", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromLessThanOrEqualTo(String value) {
            addCriterion("email_from <=", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromLike(String value) {
            addCriterion("email_from like", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromNotLike(String value) {
            addCriterion("email_from not like", value, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromIn(List<String> values) {
            addCriterion("email_from in", values, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromNotIn(List<String> values) {
            addCriterion("email_from not in", values, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromBetween(String value1, String value2) {
            addCriterion("email_from between", value1, value2, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailFromNotBetween(String value1, String value2) {
            addCriterion("email_from not between", value1, value2, "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailToIsNull() {
            addCriterion("email_to is null");
            return (Criteria) this;
        }

        public Criteria andEmailToIsNotNull() {
            addCriterion("email_to is not null");
            return (Criteria) this;
        }

        public Criteria andEmailToEqualTo(String value) {
            addCriterion("email_to =", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToNotEqualTo(String value) {
            addCriterion("email_to <>", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToGreaterThan(String value) {
            addCriterion("email_to >", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToGreaterThanOrEqualTo(String value) {
            addCriterion("email_to >=", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToLessThan(String value) {
            addCriterion("email_to <", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToLessThanOrEqualTo(String value) {
            addCriterion("email_to <=", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToLike(String value) {
            addCriterion("email_to like", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToNotLike(String value) {
            addCriterion("email_to not like", value, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToIn(List<String> values) {
            addCriterion("email_to in", values, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToNotIn(List<String> values) {
            addCriterion("email_to not in", values, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToBetween(String value1, String value2) {
            addCriterion("email_to between", value1, value2, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailToNotBetween(String value1, String value2) {
            addCriterion("email_to not between", value1, value2, "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailTitleIsNull() {
            addCriterion("email_title is null");
            return (Criteria) this;
        }

        public Criteria andEmailTitleIsNotNull() {
            addCriterion("email_title is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTitleEqualTo(String value) {
            addCriterion("email_title =", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleNotEqualTo(String value) {
            addCriterion("email_title <>", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleGreaterThan(String value) {
            addCriterion("email_title >", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleGreaterThanOrEqualTo(String value) {
            addCriterion("email_title >=", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleLessThan(String value) {
            addCriterion("email_title <", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleLessThanOrEqualTo(String value) {
            addCriterion("email_title <=", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleLike(String value) {
            addCriterion("email_title like", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleNotLike(String value) {
            addCriterion("email_title not like", value, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleIn(List<String> values) {
            addCriterion("email_title in", values, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleNotIn(List<String> values) {
            addCriterion("email_title not in", values, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleBetween(String value1, String value2) {
            addCriterion("email_title between", value1, value2, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailTitleNotBetween(String value1, String value2) {
            addCriterion("email_title not between", value1, value2, "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailContentIsNull() {
            addCriterion("email_content is null");
            return (Criteria) this;
        }

        public Criteria andEmailContentIsNotNull() {
            addCriterion("email_content is not null");
            return (Criteria) this;
        }

        public Criteria andEmailContentEqualTo(String value) {
            addCriterion("email_content =", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotEqualTo(String value) {
            addCriterion("email_content <>", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentGreaterThan(String value) {
            addCriterion("email_content >", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentGreaterThanOrEqualTo(String value) {
            addCriterion("email_content >=", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLessThan(String value) {
            addCriterion("email_content <", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLessThanOrEqualTo(String value) {
            addCriterion("email_content <=", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLike(String value) {
            addCriterion("email_content like", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotLike(String value) {
            addCriterion("email_content not like", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentIn(List<String> values) {
            addCriterion("email_content in", values, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotIn(List<String> values) {
            addCriterion("email_content not in", values, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentBetween(String value1, String value2) {
            addCriterion("email_content between", value1, value2, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotBetween(String value1, String value2) {
            addCriterion("email_content not between", value1, value2, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailBodyIsNull() {
            addCriterion("email_body is null");
            return (Criteria) this;
        }

        public Criteria andEmailBodyIsNotNull() {
            addCriterion("email_body is not null");
            return (Criteria) this;
        }

        public Criteria andEmailBodyEqualTo(String value) {
            addCriterion("email_body =", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyNotEqualTo(String value) {
            addCriterion("email_body <>", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyGreaterThan(String value) {
            addCriterion("email_body >", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyGreaterThanOrEqualTo(String value) {
            addCriterion("email_body >=", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyLessThan(String value) {
            addCriterion("email_body <", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyLessThanOrEqualTo(String value) {
            addCriterion("email_body <=", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyLike(String value) {
            addCriterion("email_body like", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyNotLike(String value) {
            addCriterion("email_body not like", value, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyIn(List<String> values) {
            addCriterion("email_body in", values, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyNotIn(List<String> values) {
            addCriterion("email_body not in", values, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyBetween(String value1, String value2) {
            addCriterion("email_body between", value1, value2, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailBodyNotBetween(String value1, String value2) {
            addCriterion("email_body not between", value1, value2, "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailFilesIsNull() {
            addCriterion("email_files is null");
            return (Criteria) this;
        }

        public Criteria andEmailFilesIsNotNull() {
            addCriterion("email_files is not null");
            return (Criteria) this;
        }

        public Criteria andEmailFilesEqualTo(String value) {
            addCriterion("email_files =", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesNotEqualTo(String value) {
            addCriterion("email_files <>", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesGreaterThan(String value) {
            addCriterion("email_files >", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesGreaterThanOrEqualTo(String value) {
            addCriterion("email_files >=", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesLessThan(String value) {
            addCriterion("email_files <", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesLessThanOrEqualTo(String value) {
            addCriterion("email_files <=", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesLike(String value) {
            addCriterion("email_files like", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesNotLike(String value) {
            addCriterion("email_files not like", value, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesIn(List<String> values) {
            addCriterion("email_files in", values, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesNotIn(List<String> values) {
            addCriterion("email_files not in", values, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesBetween(String value1, String value2) {
            addCriterion("email_files between", value1, value2, "emailFiles");
            return (Criteria) this;
        }

        public Criteria andEmailFilesNotBetween(String value1, String value2) {
            addCriterion("email_files not between", value1, value2, "emailFiles");
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

        public Criteria andEmailFromLikeInsensitive(String value) {
            addCriterion("upper(email_from) like", value.toUpperCase(), "emailFrom");
            return (Criteria) this;
        }

        public Criteria andEmailToLikeInsensitive(String value) {
            addCriterion("upper(email_to) like", value.toUpperCase(), "emailTo");
            return (Criteria) this;
        }

        public Criteria andEmailTitleLikeInsensitive(String value) {
            addCriterion("upper(email_title) like", value.toUpperCase(), "emailTitle");
            return (Criteria) this;
        }

        public Criteria andEmailContentLikeInsensitive(String value) {
            addCriterion("upper(email_content) like", value.toUpperCase(), "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailBodyLikeInsensitive(String value) {
            addCriterion("upper(email_body) like", value.toUpperCase(), "emailBody");
            return (Criteria) this;
        }

        public Criteria andEmailFilesLikeInsensitive(String value) {
            addCriterion("upper(email_files) like", value.toUpperCase(), "emailFiles");
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