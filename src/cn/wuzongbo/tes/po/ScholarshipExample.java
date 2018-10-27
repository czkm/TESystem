package cn.wuzongbo.tes.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScholarshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScholarshipExample() {
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

        public Criteria andStudentnoIsNull() {
            addCriterion("studentNo is null");
            return (Criteria) this;
        }

        public Criteria andStudentnoIsNotNull() {
            addCriterion("studentNo is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnoEqualTo(String value) {
            addCriterion("studentNo =", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoNotEqualTo(String value) {
            addCriterion("studentNo <>", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoGreaterThan(String value) {
            addCriterion("studentNo >", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoGreaterThanOrEqualTo(String value) {
            addCriterion("studentNo >=", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoLessThan(String value) {
            addCriterion("studentNo <", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoLessThanOrEqualTo(String value) {
            addCriterion("studentNo <=", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoLike(String value) {
            addCriterion("studentNo like", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoNotLike(String value) {
            addCriterion("studentNo not like", value, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoIn(List<String> values) {
            addCriterion("studentNo in", values, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoNotIn(List<String> values) {
            addCriterion("studentNo not in", values, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoBetween(String value1, String value2) {
            addCriterion("studentNo between", value1, value2, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudentnoNotBetween(String value1, String value2) {
            addCriterion("studentNo not between", value1, value2, "studentno");
            return (Criteria) this;
        }

        public Criteria andStudenttypeIsNull() {
            addCriterion("studentType is null");
            return (Criteria) this;
        }

        public Criteria andStudenttypeIsNotNull() {
            addCriterion("studentType is not null");
            return (Criteria) this;
        }

        public Criteria andStudenttypeEqualTo(String value) {
            addCriterion("studentType =", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotEqualTo(String value) {
            addCriterion("studentType <>", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeGreaterThan(String value) {
            addCriterion("studentType >", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("studentType >=", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeLessThan(String value) {
            addCriterion("studentType <", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeLessThanOrEqualTo(String value) {
            addCriterion("studentType <=", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeLike(String value) {
            addCriterion("studentType like", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotLike(String value) {
            addCriterion("studentType not like", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeIn(List<String> values) {
            addCriterion("studentType in", values, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotIn(List<String> values) {
            addCriterion("studentType not in", values, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeBetween(String value1, String value2) {
            addCriterion("studentType between", value1, value2, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotBetween(String value1, String value2) {
            addCriterion("studentType not between", value1, value2, "studenttype");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Double value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Double value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Double value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Double value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Double value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Double value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Double> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Double> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Double value1, Double value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Double value1, Double value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andMarjorIsNull() {
            addCriterion("marjor is null");
            return (Criteria) this;
        }

        public Criteria andMarjorIsNotNull() {
            addCriterion("marjor is not null");
            return (Criteria) this;
        }

        public Criteria andMarjorEqualTo(String value) {
            addCriterion("marjor =", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorNotEqualTo(String value) {
            addCriterion("marjor <>", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorGreaterThan(String value) {
            addCriterion("marjor >", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorGreaterThanOrEqualTo(String value) {
            addCriterion("marjor >=", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorLessThan(String value) {
            addCriterion("marjor <", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorLessThanOrEqualTo(String value) {
            addCriterion("marjor <=", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorLike(String value) {
            addCriterion("marjor like", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorNotLike(String value) {
            addCriterion("marjor not like", value, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorIn(List<String> values) {
            addCriterion("marjor in", values, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorNotIn(List<String> values) {
            addCriterion("marjor not in", values, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorBetween(String value1, String value2) {
            addCriterion("marjor between", value1, value2, "marjor");
            return (Criteria) this;
        }

        public Criteria andMarjorNotBetween(String value1, String value2) {
            addCriterion("marjor not between", value1, value2, "marjor");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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