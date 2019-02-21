package com.slst.datapipe.dao.pojo;

public class TConnect {
	private String cid;

	private int port;

	private Long configtime;

	private String cryptkey;

	private String comment;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid == null ? null : cid.trim();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Long getConfigtime() {
		return configtime;
	}

	public void setConfigtime(Long configtime) {
		this.configtime = configtime;
	}

	public String getCryptkey() {
		return cryptkey;
	}

	public void setCryptkey(String cryptkey) {
		this.cryptkey = cryptkey == null ? null : cryptkey.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	@Override
	public String toString() {
		return "TConnect [cid=" + cid + ", port=" + port + ", configtime=" + configtime + ", cryptkey=" + cryptkey + ", comment=" + comment + "]";
	}

}