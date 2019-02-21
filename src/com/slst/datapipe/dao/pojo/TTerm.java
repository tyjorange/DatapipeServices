package com.slst.datapipe.dao.pojo;

import java.util.Date;

public class TTerm {
	private String imei;

	private int ip;

	private Date hbtime;

	private String comment;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei == null ? null : imei.trim();
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public Date getHbtime() {
		return hbtime;
	}

	public void setHbtime(Date hbtime) {
		this.hbtime = hbtime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	@Override
	public String toString() {
		return "TTerm [imei=" + imei + ", ip=" + ip + ", hbtime=" + hbtime + ", comment=" + comment + "]";
	}

}