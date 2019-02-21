package com.slst.datapipe.dao.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TConnectExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TConnectExample() {
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

		public Criteria andCidIsNull() {
			addCriterion("CID is null");
			return (Criteria) this;
		}

		public Criteria andCidIsNotNull() {
			addCriterion("CID is not null");
			return (Criteria) this;
		}

		public Criteria andCidEqualTo(String value) {
			addCriterion("CID =", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotEqualTo(String value) {
			addCriterion("CID <>", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThan(String value) {
			addCriterion("CID >", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThanOrEqualTo(String value) {
			addCriterion("CID >=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThan(String value) {
			addCriterion("CID <", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThanOrEqualTo(String value) {
			addCriterion("CID <=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLike(String value) {
			addCriterion("CID like", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotLike(String value) {
			addCriterion("CID not like", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidIn(List<String> values) {
			addCriterion("CID in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotIn(List<String> values) {
			addCriterion("CID not in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidBetween(String value1, String value2) {
			addCriterion("CID between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotBetween(String value1, String value2) {
			addCriterion("CID not between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andPortIsNull() {
			addCriterion("PORT is null");
			return (Criteria) this;
		}

		public Criteria andPortIsNotNull() {
			addCriterion("PORT is not null");
			return (Criteria) this;
		}

		public Criteria andPortEqualTo(Short value) {
			addCriterion("PORT =", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortNotEqualTo(Short value) {
			addCriterion("PORT <>", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortGreaterThan(Short value) {
			addCriterion("PORT >", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortGreaterThanOrEqualTo(Short value) {
			addCriterion("PORT >=", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortLessThan(Short value) {
			addCriterion("PORT <", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortLessThanOrEqualTo(Short value) {
			addCriterion("PORT <=", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortIn(List<Short> values) {
			addCriterion("PORT in", values, "port");
			return (Criteria) this;
		}

		public Criteria andPortNotIn(List<Short> values) {
			addCriterion("PORT not in", values, "port");
			return (Criteria) this;
		}

		public Criteria andPortBetween(Short value1, Short value2) {
			addCriterion("PORT between", value1, value2, "port");
			return (Criteria) this;
		}

		public Criteria andPortNotBetween(Short value1, Short value2) {
			addCriterion("PORT not between", value1, value2, "port");
			return (Criteria) this;
		}

		public Criteria andConfigtimeIsNull() {
			addCriterion("CONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andConfigtimeIsNotNull() {
			addCriterion("CONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andConfigtimeEqualTo(Long value) {
			addCriterion("CONFIGTIME =", value, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeNotEqualTo(Long value) {
			addCriterion("CONFIGTIME <>", value, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeGreaterThan(Long value) {
			addCriterion("CONFIGTIME >", value, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeGreaterThanOrEqualTo(Long value) {
			addCriterion("CONFIGTIME >=", value, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeLessThan(Long value) {
			addCriterion("CONFIGTIME <", value, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeLessThanOrEqualTo(Long value) {
			addCriterion("CONFIGTIME <=", value, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeIn(List<Long> values) {
			addCriterion("CONFIGTIME in", values, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeNotIn(List<Long> values) {
			addCriterion("CONFIGTIME not in", values, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeBetween(Long value1, Long value2) {
			addCriterion("CONFIGTIME between", value1, value2, "configtime");
			return (Criteria) this;
		}

		public Criteria andConfigtimeNotBetween(Long value1, Long value2) {
			addCriterion("CONFIGTIME not between", value1, value2, "configtime");
			return (Criteria) this;
		}

		public Criteria andCryptkeyIsNull() {
			addCriterion("CRYPTKEY is null");
			return (Criteria) this;
		}

		public Criteria andCryptkeyIsNotNull() {
			addCriterion("CRYPTKEY is not null");
			return (Criteria) this;
		}

		public Criteria andCryptkeyEqualTo(String value) {
			addCriterion("CRYPTKEY =", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyNotEqualTo(String value) {
			addCriterion("CRYPTKEY <>", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyGreaterThan(String value) {
			addCriterion("CRYPTKEY >", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyGreaterThanOrEqualTo(String value) {
			addCriterion("CRYPTKEY >=", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyLessThan(String value) {
			addCriterion("CRYPTKEY <", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyLessThanOrEqualTo(String value) {
			addCriterion("CRYPTKEY <=", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyLike(String value) {
			addCriterion("CRYPTKEY like", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyNotLike(String value) {
			addCriterion("CRYPTKEY not like", value, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyIn(List<String> values) {
			addCriterion("CRYPTKEY in", values, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyNotIn(List<String> values) {
			addCriterion("CRYPTKEY not in", values, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyBetween(String value1, String value2) {
			addCriterion("CRYPTKEY between", value1, value2, "cryptkey");
			return (Criteria) this;
		}

		public Criteria andCryptkeyNotBetween(String value1, String value2) {
			addCriterion("CRYPTKEY not between", value1, value2, "cryptkey");
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