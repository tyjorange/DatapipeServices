package com.slst.datapipe.dao.pojo;

public class TConnectterm {
	private String ctid;

	private TConnect connect;

	private TTerm term;

	private Byte socketmode;

	public String getCtid() {
		return ctid;
	}

	public void setCtid(String ctid) {
		this.ctid = ctid == null ? null : ctid.trim();
	}

	public TConnect getConnect() {
		return connect;
	}

	public void setConnect(TConnect connect) {
		this.connect = connect;
	}

	public TTerm getTerm() {
		return term;
	}

	public void setTerm(TTerm term) {
		this.term = term;
	}

	public Byte getSocketmode() {
		return socketmode;
	}

	public void setSocketmode(Byte socketmode) {
		this.socketmode = socketmode;
	}

	@Override
	public String toString() {
		return "TConnectterm [ctid=" + ctid + ", connect=" + connect + ", term=" + term + ", socketmode=" + socketmode + "]";
	}

}