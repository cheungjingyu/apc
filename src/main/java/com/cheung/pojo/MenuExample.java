package com.cheung.pojo;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
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

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(String value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(String value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(String value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(String value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(String value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(String value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLike(String value) {
            addCriterion("typeid like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotLike(String value) {
            addCriterion("typeid not like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<String> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<String> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(String value1, String value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(String value1, String value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andBurdenIsNull() {
            addCriterion("burden is null");
            return (Criteria) this;
        }

        public Criteria andBurdenIsNotNull() {
            addCriterion("burden is not null");
            return (Criteria) this;
        }

        public Criteria andBurdenEqualTo(String value) {
            addCriterion("burden =", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenNotEqualTo(String value) {
            addCriterion("burden <>", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenGreaterThan(String value) {
            addCriterion("burden >", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenGreaterThanOrEqualTo(String value) {
            addCriterion("burden >=", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenLessThan(String value) {
            addCriterion("burden <", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenLessThanOrEqualTo(String value) {
            addCriterion("burden <=", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenLike(String value) {
            addCriterion("burden like", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenNotLike(String value) {
            addCriterion("burden not like", value, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenIn(List<String> values) {
            addCriterion("burden in", values, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenNotIn(List<String> values) {
            addCriterion("burden not in", values, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenBetween(String value1, String value2) {
            addCriterion("burden between", value1, value2, "burden");
            return (Criteria) this;
        }

        public Criteria andBurdenNotBetween(String value1, String value2) {
            addCriterion("burden not between", value1, value2, "burden");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSumsIsNull() {
            addCriterion("sums is null");
            return (Criteria) this;
        }

        public Criteria andSumsIsNotNull() {
            addCriterion("sums is not null");
            return (Criteria) this;
        }

        public Criteria andSumsEqualTo(String value) {
            addCriterion("sums =", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsNotEqualTo(String value) {
            addCriterion("sums <>", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsGreaterThan(String value) {
            addCriterion("sums >", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsGreaterThanOrEqualTo(String value) {
            addCriterion("sums >=", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsLessThan(String value) {
            addCriterion("sums <", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsLessThanOrEqualTo(String value) {
            addCriterion("sums <=", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsLike(String value) {
            addCriterion("sums like", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsNotLike(String value) {
            addCriterion("sums not like", value, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsIn(List<String> values) {
            addCriterion("sums in", values, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsNotIn(List<String> values) {
            addCriterion("sums not in", values, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsBetween(String value1, String value2) {
            addCriterion("sums between", value1, value2, "sums");
            return (Criteria) this;
        }

        public Criteria andSumsNotBetween(String value1, String value2) {
            addCriterion("sums not between", value1, value2, "sums");
            return (Criteria) this;
        }

        public Criteria andPrice1IsNull() {
            addCriterion("price1 is null");
            return (Criteria) this;
        }

        public Criteria andPrice1IsNotNull() {
            addCriterion("price1 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice1EqualTo(String value) {
            addCriterion("price1 =", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotEqualTo(String value) {
            addCriterion("price1 <>", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1GreaterThan(String value) {
            addCriterion("price1 >", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1GreaterThanOrEqualTo(String value) {
            addCriterion("price1 >=", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1LessThan(String value) {
            addCriterion("price1 <", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1LessThanOrEqualTo(String value) {
            addCriterion("price1 <=", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1Like(String value) {
            addCriterion("price1 like", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotLike(String value) {
            addCriterion("price1 not like", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1In(List<String> values) {
            addCriterion("price1 in", values, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotIn(List<String> values) {
            addCriterion("price1 not in", values, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1Between(String value1, String value2) {
            addCriterion("price1 between", value1, value2, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotBetween(String value1, String value2) {
            addCriterion("price1 not between", value1, value2, "price1");
            return (Criteria) this;
        }

        public Criteria andSums1IsNull() {
            addCriterion("sums1 is null");
            return (Criteria) this;
        }

        public Criteria andSums1IsNotNull() {
            addCriterion("sums1 is not null");
            return (Criteria) this;
        }

        public Criteria andSums1EqualTo(String value) {
            addCriterion("sums1 =", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1NotEqualTo(String value) {
            addCriterion("sums1 <>", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1GreaterThan(String value) {
            addCriterion("sums1 >", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1GreaterThanOrEqualTo(String value) {
            addCriterion("sums1 >=", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1LessThan(String value) {
            addCriterion("sums1 <", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1LessThanOrEqualTo(String value) {
            addCriterion("sums1 <=", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1Like(String value) {
            addCriterion("sums1 like", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1NotLike(String value) {
            addCriterion("sums1 not like", value, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1In(List<String> values) {
            addCriterion("sums1 in", values, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1NotIn(List<String> values) {
            addCriterion("sums1 not in", values, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1Between(String value1, String value2) {
            addCriterion("sums1 between", value1, value2, "sums1");
            return (Criteria) this;
        }

        public Criteria andSums1NotBetween(String value1, String value2) {
            addCriterion("sums1 not between", value1, value2, "sums1");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
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