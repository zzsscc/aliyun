package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblLogRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblLogRecordExample() {
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

        public Criteria andLoggerTypeIsNull() {
            addCriterion("logger_type is null");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeIsNotNull() {
            addCriterion("logger_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeEqualTo(String value) {
            addCriterion("logger_type =", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeNotEqualTo(String value) {
            addCriterion("logger_type <>", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeGreaterThan(String value) {
            addCriterion("logger_type >", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("logger_type >=", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeLessThan(String value) {
            addCriterion("logger_type <", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeLessThanOrEqualTo(String value) {
            addCriterion("logger_type <=", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeLike(String value) {
            addCriterion("logger_type like", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeNotLike(String value) {
            addCriterion("logger_type not like", value, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeIn(List<String> values) {
            addCriterion("logger_type in", values, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeNotIn(List<String> values) {
            addCriterion("logger_type not in", values, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeBetween(String value1, String value2) {
            addCriterion("logger_type between", value1, value2, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerTypeNotBetween(String value1, String value2) {
            addCriterion("logger_type not between", value1, value2, "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerDescIsNull() {
            addCriterion("logger_desc is null");
            return (Criteria) this;
        }

        public Criteria andLoggerDescIsNotNull() {
            addCriterion("logger_desc is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerDescEqualTo(String value) {
            addCriterion("logger_desc =", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescNotEqualTo(String value) {
            addCriterion("logger_desc <>", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescGreaterThan(String value) {
            addCriterion("logger_desc >", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescGreaterThanOrEqualTo(String value) {
            addCriterion("logger_desc >=", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescLessThan(String value) {
            addCriterion("logger_desc <", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescLessThanOrEqualTo(String value) {
            addCriterion("logger_desc <=", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescLike(String value) {
            addCriterion("logger_desc like", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescNotLike(String value) {
            addCriterion("logger_desc not like", value, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescIn(List<String> values) {
            addCriterion("logger_desc in", values, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescNotIn(List<String> values) {
            addCriterion("logger_desc not in", values, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescBetween(String value1, String value2) {
            addCriterion("logger_desc between", value1, value2, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerDescNotBetween(String value1, String value2) {
            addCriterion("logger_desc not between", value1, value2, "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionIsNull() {
            addCriterion("logger_seesion is null");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionIsNotNull() {
            addCriterion("logger_seesion is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionEqualTo(String value) {
            addCriterion("logger_seesion =", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionNotEqualTo(String value) {
            addCriterion("logger_seesion <>", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionGreaterThan(String value) {
            addCriterion("logger_seesion >", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionGreaterThanOrEqualTo(String value) {
            addCriterion("logger_seesion >=", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionLessThan(String value) {
            addCriterion("logger_seesion <", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionLessThanOrEqualTo(String value) {
            addCriterion("logger_seesion <=", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionLike(String value) {
            addCriterion("logger_seesion like", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionNotLike(String value) {
            addCriterion("logger_seesion not like", value, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionIn(List<String> values) {
            addCriterion("logger_seesion in", values, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionNotIn(List<String> values) {
            addCriterion("logger_seesion not in", values, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionBetween(String value1, String value2) {
            addCriterion("logger_seesion between", value1, value2, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionNotBetween(String value1, String value2) {
            addCriterion("logger_seesion not between", value1, value2, "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidIsNull() {
            addCriterion("logger_linkid is null");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidIsNotNull() {
            addCriterion("logger_linkid is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidEqualTo(String value) {
            addCriterion("logger_linkid =", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidNotEqualTo(String value) {
            addCriterion("logger_linkid <>", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidGreaterThan(String value) {
            addCriterion("logger_linkid >", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidGreaterThanOrEqualTo(String value) {
            addCriterion("logger_linkid >=", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidLessThan(String value) {
            addCriterion("logger_linkid <", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidLessThanOrEqualTo(String value) {
            addCriterion("logger_linkid <=", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidLike(String value) {
            addCriterion("logger_linkid like", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidNotLike(String value) {
            addCriterion("logger_linkid not like", value, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidIn(List<String> values) {
            addCriterion("logger_linkid in", values, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidNotIn(List<String> values) {
            addCriterion("logger_linkid not in", values, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidBetween(String value1, String value2) {
            addCriterion("logger_linkid between", value1, value2, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidNotBetween(String value1, String value2) {
            addCriterion("logger_linkid not between", value1, value2, "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerIpIsNull() {
            addCriterion("logger_ip is null");
            return (Criteria) this;
        }

        public Criteria andLoggerIpIsNotNull() {
            addCriterion("logger_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerIpEqualTo(String value) {
            addCriterion("logger_ip =", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpNotEqualTo(String value) {
            addCriterion("logger_ip <>", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpGreaterThan(String value) {
            addCriterion("logger_ip >", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpGreaterThanOrEqualTo(String value) {
            addCriterion("logger_ip >=", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpLessThan(String value) {
            addCriterion("logger_ip <", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpLessThanOrEqualTo(String value) {
            addCriterion("logger_ip <=", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpLike(String value) {
            addCriterion("logger_ip like", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpNotLike(String value) {
            addCriterion("logger_ip not like", value, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpIn(List<String> values) {
            addCriterion("logger_ip in", values, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpNotIn(List<String> values) {
            addCriterion("logger_ip not in", values, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpBetween(String value1, String value2) {
            addCriterion("logger_ip between", value1, value2, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerIpNotBetween(String value1, String value2) {
            addCriterion("logger_ip not between", value1, value2, "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentIsNull() {
            addCriterion("logger_agent is null");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentIsNotNull() {
            addCriterion("logger_agent is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentEqualTo(String value) {
            addCriterion("logger_agent =", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentNotEqualTo(String value) {
            addCriterion("logger_agent <>", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentGreaterThan(String value) {
            addCriterion("logger_agent >", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentGreaterThanOrEqualTo(String value) {
            addCriterion("logger_agent >=", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentLessThan(String value) {
            addCriterion("logger_agent <", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentLessThanOrEqualTo(String value) {
            addCriterion("logger_agent <=", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentLike(String value) {
            addCriterion("logger_agent like", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentNotLike(String value) {
            addCriterion("logger_agent not like", value, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentIn(List<String> values) {
            addCriterion("logger_agent in", values, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentNotIn(List<String> values) {
            addCriterion("logger_agent not in", values, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentBetween(String value1, String value2) {
            addCriterion("logger_agent between", value1, value2, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentNotBetween(String value1, String value2) {
            addCriterion("logger_agent not between", value1, value2, "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentIsNull() {
            addCriterion("logger_content is null");
            return (Criteria) this;
        }

        public Criteria andLoggerContentIsNotNull() {
            addCriterion("logger_content is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerContentEqualTo(String value) {
            addCriterion("logger_content =", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentNotEqualTo(String value) {
            addCriterion("logger_content <>", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentGreaterThan(String value) {
            addCriterion("logger_content >", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentGreaterThanOrEqualTo(String value) {
            addCriterion("logger_content >=", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentLessThan(String value) {
            addCriterion("logger_content <", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentLessThanOrEqualTo(String value) {
            addCriterion("logger_content <=", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentLike(String value) {
            addCriterion("logger_content like", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentNotLike(String value) {
            addCriterion("logger_content not like", value, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentIn(List<String> values) {
            addCriterion("logger_content in", values, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentNotIn(List<String> values) {
            addCriterion("logger_content not in", values, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentBetween(String value1, String value2) {
            addCriterion("logger_content between", value1, value2, "loggerContent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentNotBetween(String value1, String value2) {
            addCriterion("logger_content not between", value1, value2, "loggerContent");
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

        public Criteria andLoggerTypeLikeInsensitive(String value) {
            addCriterion("upper(logger_type) like", value.toUpperCase(), "loggerType");
            return (Criteria) this;
        }

        public Criteria andLoggerDescLikeInsensitive(String value) {
            addCriterion("upper(logger_desc) like", value.toUpperCase(), "loggerDesc");
            return (Criteria) this;
        }

        public Criteria andLoggerSeesionLikeInsensitive(String value) {
            addCriterion("upper(logger_seesion) like", value.toUpperCase(), "loggerSeesion");
            return (Criteria) this;
        }

        public Criteria andLoggerLinkidLikeInsensitive(String value) {
            addCriterion("upper(logger_linkid) like", value.toUpperCase(), "loggerLinkid");
            return (Criteria) this;
        }

        public Criteria andLoggerIpLikeInsensitive(String value) {
            addCriterion("upper(logger_ip) like", value.toUpperCase(), "loggerIp");
            return (Criteria) this;
        }

        public Criteria andLoggerAgentLikeInsensitive(String value) {
            addCriterion("upper(logger_agent) like", value.toUpperCase(), "loggerAgent");
            return (Criteria) this;
        }

        public Criteria andLoggerContentLikeInsensitive(String value) {
            addCriterion("upper(logger_content) like", value.toUpperCase(), "loggerContent");
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