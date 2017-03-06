package com.eshutech.biz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblIsvInstancesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblIsvInstancesExample() {
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

        public Criteria andInstanceIdIsNull() {
            addCriterion("instance_id is null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNotNull() {
            addCriterion("instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdEqualTo(String value) {
            addCriterion("instance_id =", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotEqualTo(String value) {
            addCriterion("instance_id <>", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThan(String value) {
            addCriterion("instance_id >", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("instance_id >=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThan(String value) {
            addCriterion("instance_id <", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("instance_id <=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLike(String value) {
            addCriterion("instance_id like", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotLike(String value) {
            addCriterion("instance_id not like", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIn(List<String> values) {
            addCriterion("instance_id in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotIn(List<String> values) {
            addCriterion("instance_id not in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdBetween(String value1, String value2) {
            addCriterion("instance_id between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotBetween(String value1, String value2) {
            addCriterion("instance_id not between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAliUidIsNull() {
            addCriterion("ali_uid is null");
            return (Criteria) this;
        }

        public Criteria andAliUidIsNotNull() {
            addCriterion("ali_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAliUidEqualTo(String value) {
            addCriterion("ali_uid =", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidNotEqualTo(String value) {
            addCriterion("ali_uid <>", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidGreaterThan(String value) {
            addCriterion("ali_uid >", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidGreaterThanOrEqualTo(String value) {
            addCriterion("ali_uid >=", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidLessThan(String value) {
            addCriterion("ali_uid <", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidLessThanOrEqualTo(String value) {
            addCriterion("ali_uid <=", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidLike(String value) {
            addCriterion("ali_uid like", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidNotLike(String value) {
            addCriterion("ali_uid not like", value, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidIn(List<String> values) {
            addCriterion("ali_uid in", values, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidNotIn(List<String> values) {
            addCriterion("ali_uid not in", values, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidBetween(String value1, String value2) {
            addCriterion("ali_uid between", value1, value2, "aliUid");
            return (Criteria) this;
        }

        public Criteria andAliUidNotBetween(String value1, String value2) {
            addCriterion("ali_uid not between", value1, value2, "aliUid");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdIsNull() {
            addCriterion("order_biz_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdIsNotNull() {
            addCriterion("order_biz_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdEqualTo(String value) {
            addCriterion("order_biz_id =", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdNotEqualTo(String value) {
            addCriterion("order_biz_id <>", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdGreaterThan(String value) {
            addCriterion("order_biz_id >", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_biz_id >=", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdLessThan(String value) {
            addCriterion("order_biz_id <", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdLessThanOrEqualTo(String value) {
            addCriterion("order_biz_id <=", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdLike(String value) {
            addCriterion("order_biz_id like", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdNotLike(String value) {
            addCriterion("order_biz_id not like", value, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdIn(List<String> values) {
            addCriterion("order_biz_id in", values, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdNotIn(List<String> values) {
            addCriterion("order_biz_id not in", values, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdBetween(String value1, String value2) {
            addCriterion("order_biz_id between", value1, value2, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdNotBetween(String value1, String value2) {
            addCriterion("order_biz_id not between", value1, value2, "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(String value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(String value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(String value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(String value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(String value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLike(String value) {
            addCriterion("sku_id like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotLike(String value) {
            addCriterion("sku_id not like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<String> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<String> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(String value1, String value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(String value1, String value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityIsNull() {
            addCriterion("account_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityIsNotNull() {
            addCriterion("account_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityEqualTo(String value) {
            addCriterion("account_quantity =", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityNotEqualTo(String value) {
            addCriterion("account_quantity <>", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityGreaterThan(String value) {
            addCriterion("account_quantity >", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("account_quantity >=", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityLessThan(String value) {
            addCriterion("account_quantity <", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityLessThanOrEqualTo(String value) {
            addCriterion("account_quantity <=", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityLike(String value) {
            addCriterion("account_quantity like", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityNotLike(String value) {
            addCriterion("account_quantity not like", value, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityIn(List<String> values) {
            addCriterion("account_quantity in", values, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityNotIn(List<String> values) {
            addCriterion("account_quantity not in", values, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityBetween(String value1, String value2) {
            addCriterion("account_quantity between", value1, value2, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityNotBetween(String value1, String value2) {
            addCriterion("account_quantity not between", value1, value2, "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andExpiredOnIsNull() {
            addCriterion("expired_on is null");
            return (Criteria) this;
        }

        public Criteria andExpiredOnIsNotNull() {
            addCriterion("expired_on is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredOnEqualTo(String value) {
            addCriterion("expired_on =", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnNotEqualTo(String value) {
            addCriterion("expired_on <>", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnGreaterThan(String value) {
            addCriterion("expired_on >", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnGreaterThanOrEqualTo(String value) {
            addCriterion("expired_on >=", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnLessThan(String value) {
            addCriterion("expired_on <", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnLessThanOrEqualTo(String value) {
            addCriterion("expired_on <=", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnLike(String value) {
            addCriterion("expired_on like", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnNotLike(String value) {
            addCriterion("expired_on not like", value, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnIn(List<String> values) {
            addCriterion("expired_on in", values, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnNotIn(List<String> values) {
            addCriterion("expired_on not in", values, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnBetween(String value1, String value2) {
            addCriterion("expired_on between", value1, value2, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andExpiredOnNotBetween(String value1, String value2) {
            addCriterion("expired_on not between", value1, value2, "expiredOn");
            return (Criteria) this;
        }

        public Criteria andTemplateIsNull() {
            addCriterion("template is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIsNotNull() {
            addCriterion("template is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateEqualTo(String value) {
            addCriterion("template =", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotEqualTo(String value) {
            addCriterion("template <>", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateGreaterThan(String value) {
            addCriterion("template >", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("template >=", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateLessThan(String value) {
            addCriterion("template <", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateLessThanOrEqualTo(String value) {
            addCriterion("template <=", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateLike(String value) {
            addCriterion("template like", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotLike(String value) {
            addCriterion("template not like", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateIn(List<String> values) {
            addCriterion("template in", values, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotIn(List<String> values) {
            addCriterion("template not in", values, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateBetween(String value1, String value2) {
            addCriterion("template between", value1, value2, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotBetween(String value1, String value2) {
            addCriterion("template not between", value1, value2, "template");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("corp_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(String value) {
            addCriterion("corp_id =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(String value) {
            addCriterion("corp_id <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(String value) {
            addCriterion("corp_id >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(String value) {
            addCriterion("corp_id >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(String value) {
            addCriterion("corp_id <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(String value) {
            addCriterion("corp_id <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLike(String value) {
            addCriterion("corp_id like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotLike(String value) {
            addCriterion("corp_id not like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<String> values) {
            addCriterion("corp_id in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<String> values) {
            addCriterion("corp_id not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(String value1, String value2) {
            addCriterion("corp_id between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(String value1, String value2) {
            addCriterion("corp_id not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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

        public Criteria andKeywordLimitIsNull() {
            addCriterion("keyword_limit is null");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitIsNotNull() {
            addCriterion("keyword_limit is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitEqualTo(Integer value) {
            addCriterion("keyword_limit =", value, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitNotEqualTo(Integer value) {
            addCriterion("keyword_limit <>", value, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitGreaterThan(Integer value) {
            addCriterion("keyword_limit >", value, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("keyword_limit >=", value, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitLessThan(Integer value) {
            addCriterion("keyword_limit <", value, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitLessThanOrEqualTo(Integer value) {
            addCriterion("keyword_limit <=", value, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitIn(List<Integer> values) {
            addCriterion("keyword_limit in", values, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitNotIn(List<Integer> values) {
            addCriterion("keyword_limit not in", values, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitBetween(Integer value1, Integer value2) {
            addCriterion("keyword_limit between", value1, value2, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andKeywordLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("keyword_limit not between", value1, value2, "keywordLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitIsNull() {
            addCriterion("topic_limit is null");
            return (Criteria) this;
        }

        public Criteria andTopicLimitIsNotNull() {
            addCriterion("topic_limit is not null");
            return (Criteria) this;
        }

        public Criteria andTopicLimitEqualTo(Integer value) {
            addCriterion("topic_limit =", value, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitNotEqualTo(Integer value) {
            addCriterion("topic_limit <>", value, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitGreaterThan(Integer value) {
            addCriterion("topic_limit >", value, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_limit >=", value, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitLessThan(Integer value) {
            addCriterion("topic_limit <", value, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitLessThanOrEqualTo(Integer value) {
            addCriterion("topic_limit <=", value, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitIn(List<Integer> values) {
            addCriterion("topic_limit in", values, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitNotIn(List<Integer> values) {
            addCriterion("topic_limit not in", values, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitBetween(Integer value1, Integer value2) {
            addCriterion("topic_limit between", value1, value2, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andTopicLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_limit not between", value1, value2, "topicLimit");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisIsNull() {
            addCriterion("weibo_analysis is null");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisIsNotNull() {
            addCriterion("weibo_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisEqualTo(Integer value) {
            addCriterion("weibo_analysis =", value, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisNotEqualTo(Integer value) {
            addCriterion("weibo_analysis <>", value, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisGreaterThan(Integer value) {
            addCriterion("weibo_analysis >", value, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisGreaterThanOrEqualTo(Integer value) {
            addCriterion("weibo_analysis >=", value, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisLessThan(Integer value) {
            addCriterion("weibo_analysis <", value, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisLessThanOrEqualTo(Integer value) {
            addCriterion("weibo_analysis <=", value, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisIn(List<Integer> values) {
            addCriterion("weibo_analysis in", values, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisNotIn(List<Integer> values) {
            addCriterion("weibo_analysis not in", values, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisBetween(Integer value1, Integer value2) {
            addCriterion("weibo_analysis between", value1, value2, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andWeiboAnalysisNotBetween(Integer value1, Integer value2) {
            addCriterion("weibo_analysis not between", value1, value2, "weiboAnalysis");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitIsNull() {
            addCriterion("sentiment_limit is null");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitIsNotNull() {
            addCriterion("sentiment_limit is not null");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitEqualTo(Integer value) {
            addCriterion("sentiment_limit =", value, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitNotEqualTo(Integer value) {
            addCriterion("sentiment_limit <>", value, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitGreaterThan(Integer value) {
            addCriterion("sentiment_limit >", value, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("sentiment_limit >=", value, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitLessThan(Integer value) {
            addCriterion("sentiment_limit <", value, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitLessThanOrEqualTo(Integer value) {
            addCriterion("sentiment_limit <=", value, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitIn(List<Integer> values) {
            addCriterion("sentiment_limit in", values, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitNotIn(List<Integer> values) {
            addCriterion("sentiment_limit not in", values, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitBetween(Integer value1, Integer value2) {
            addCriterion("sentiment_limit between", value1, value2, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andSentimentLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("sentiment_limit not between", value1, value2, "sentimentLimit");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLikeInsensitive(String value) {
            addCriterion("upper(instance_id) like", value.toUpperCase(), "instanceId");
            return (Criteria) this;
        }

        public Criteria andAliUidLikeInsensitive(String value) {
            addCriterion("upper(ali_uid) like", value.toUpperCase(), "aliUid");
            return (Criteria) this;
        }

        public Criteria andOrderBizIdLikeInsensitive(String value) {
            addCriterion("upper(order_biz_id) like", value.toUpperCase(), "orderBizId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLikeInsensitive(String value) {
            addCriterion("upper(order_id) like", value.toUpperCase(), "orderId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLikeInsensitive(String value) {
            addCriterion("upper(sku_id) like", value.toUpperCase(), "skuId");
            return (Criteria) this;
        }

        public Criteria andAccountQuantityLikeInsensitive(String value) {
            addCriterion("upper(account_quantity) like", value.toUpperCase(), "accountQuantity");
            return (Criteria) this;
        }

        public Criteria andExpiredOnLikeInsensitive(String value) {
            addCriterion("upper(expired_on) like", value.toUpperCase(), "expiredOn");
            return (Criteria) this;
        }

        public Criteria andTemplateLikeInsensitive(String value) {
            addCriterion("upper(template) like", value.toUpperCase(), "template");
            return (Criteria) this;
        }

        public Criteria andCorpIdLikeInsensitive(String value) {
            addCriterion("upper(corp_id) like", value.toUpperCase(), "corpId");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(email) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
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