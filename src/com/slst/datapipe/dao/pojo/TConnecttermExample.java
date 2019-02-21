package com.slst.datapipe.dao.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TConnecttermExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TConnecttermExample() {
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

		public Criteria andCtidIsNull() {
			addCriterion("CTID is null");
			return (Criteria) this;
		}

		public Criteria andCtidIsNotNull() {
			addCriterion("CTID is not null");
			return (Criteria) this;
		}

		public Criteria andCtidEqualTo(String value) {
			addCriterion("CTID =", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidNotEqualTo(String value) {
			addCriterion("CTID <>", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidGreaterThan(String value) {
			addCriterion("CTID >", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidGreaterThanOrEqualTo(String value) {
			addCriterion("CTID >=", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidLessThan(String value) {
			addCriterion("CTID <", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidLessThanOrEqualTo(String value) {
			addCriterion("CTID <=", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidLike(String value) {
			addCriterion("CTID like", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidNotLike(String value) {
			addCriterion("CTID not like", value, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidIn(List<String> values) {
			addCriterion("CTID in", values, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidNotIn(List<String> values) {
			addCriterion("CTID not in", values, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidBetween(String value1, String value2) {
			addCriterion("CTID between", value1, value2, "ctid");
			return (Criteria) this;
		}

		public Criteria andCtidNotBetween(String value1, String value2) {
			addCriterion("CTID not between", value1, value2, "ctid");
			return (Criteria) this;
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
			addCriterion("t_connectterm.CID =", value, "cid");//FIXME
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

		public Criteria andImeiIsNull() {
			addCriterion("IMEI is null");
			return (Criteria) this;
		}

		public Criteria andImeiIsNotNull() {
			addCriterion("IMEI is not null");
			return (Criteria) this;
		}

		public Criteria andImeiEqualTo(String value) {
			addCriterion("t_connectterm.IMEI =", value, "imei");//FIXME
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
			addCriterion("t_connectterm.IMEI not like", value, "imei");//FIXME
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

		public Criteria andSocketmodeIsNull() {
			addCriterion("SOCKETMODE is null");
			return (Criteria) this;
		}

		public Criteria andSocketmodeIsNotNull() {
			addCriterion("SOCKETMODE is not null");
			return (Criteria) this;
		}

		public Criteria andSocketmodeEqualTo(Byte value) {
			addCriterion("SOCKETMODE =", value, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeNotEqualTo(Byte value) {
			addCriterion("SOCKETMODE <>", value, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeGreaterThan(Byte value) {
			addCriterion("SOCKETMODE >", value, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SOCKETMODE >=", value, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeLessThan(Byte value) {
			addCriterion("SOCKETMODE <", value, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeLessThanOrEqualTo(Byte value) {
			addCriterion("SOCKETMODE <=", value, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeIn(List<Byte> values) {
			addCriterion("SOCKETMODE in", values, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeNotIn(List<Byte> values) {
			addCriterion("SOCKETMODE not in", values, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeBetween(Byte value1, Byte value2) {
			addCriterion("SOCKETMODE between", value1, value2, "socketmode");
			return (Criteria) this;
		}

		public Criteria andSocketmodeNotBetween(Byte value1, Byte value2) {
			addCriterion("SOCKETMODE not between", value1, value2, "socketmode");
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