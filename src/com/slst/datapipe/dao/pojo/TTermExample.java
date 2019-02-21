package com.slst.datapipe.dao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TTermExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TTermExample() {
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

		public Criteria andImeiIsNull() {
			addCriterion("IMEI is null");
			return (Criteria) this;
		}

		public Criteria andImeiIsNotNull() {
			addCriterion("IMEI is not null");
			return (Criteria) this;
		}

		public Criteria andImeiEqualTo(String value) {
			addCriterion("IMEI =", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiNotEqualTo(String value) {
			addCriterion("IMEI <>", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiGreaterThan(String value) {
			addCriterion("IMEI >", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiGreaterThanOrEqualTo(String value) {
			addCriterion("IMEI >=", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiLessThan(String value) {
			addCriterion("IMEI <", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiLessThanOrEqualTo(String value) {
			addCriterion("IMEI <=", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiLike(String value) {
			addCriterion("IMEI like", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiNotLike(String value) {
			addCriterion("IMEI not like", value, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiIn(List<String> values) {
			addCriterion("IMEI in", values, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiNotIn(List<String> values) {
			addCriterion("IMEI not in", values, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiBetween(String value1, String value2) {
			addCriterion("IMEI between", value1, value2, "imei");
			return (Criteria) this;
		}

		public Criteria andImeiNotBetween(String value1, String value2) {
			addCriterion("IMEI not between", value1, value2, "imei");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("IP is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("IP is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(Long value) {
			addCriterion("IP =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(Long value) {
			addCriterion("IP <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(Long value) {
			addCriterion("IP >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(Long value) {
			addCriterion("IP >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(Long value) {
			addCriterion("IP <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(Long value) {
			addCriterion("IP <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<Long> values) {
			addCriterion("IP in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<Long> values) {
			addCriterion("IP not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(Long value1, Long value2) {
			addCriterion("IP between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(Long value1, Long value2) {
			addCriterion("IP not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andHbtimeIsNull() {
			addCriterion("HBTIME is null");
			return (Criteria) this;
		}

		public Criteria andHbtimeIsNotNull() {
			addCriterion("HBTIME is not null");
			return (Criteria) this;
		}

		public Criteria andHbtimeEqualTo(Date value) {
			addCriterion("HBTIME =", value, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeNotEqualTo(Date value) {
			addCriterion("HBTIME <>", value, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeGreaterThan(Date value) {
			addCriterion("HBTIME >", value, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("HBTIME >=", value, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeLessThan(Date value) {
			addCriterion("HBTIME <", value, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeLessThanOrEqualTo(Date value) {
			addCriterion("HBTIME <=", value, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeIn(List<Date> values) {
			addCriterion("HBTIME in", values, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeNotIn(List<Date> values) {
			addCriterion("HBTIME not in", values, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeBetween(Date value1, Date value2) {
			addCriterion("HBTIME between", value1, value2, "hbtime");
			return (Criteria) this;
		}

		public Criteria andHbtimeNotBetween(Date value1, Date value2) {
			addCriterion("HBTIME not between", value1, value2, "hbtime");
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