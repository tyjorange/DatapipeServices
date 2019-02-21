package com.slst.datapipe.msg.decode;

import org.springframework.stereotype.Component;

/**
 * 终端信息bean
 * 
 * @author tyj
 *
 */
@Component
public class Bean_TermInfo implements IBean {
	private String IMEI;
	private int IP;
	private Short sum;

	public Short getSum() {
		return sum;
	}

	public void setSum(Short sum) {
		this.sum = sum;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public void setIP(int iP) {
		IP = iP;
	}

	public String getIMEI() {
		return IMEI;
	}

	public int getIP() {
		return IP;
	}

	@Override
	public String toString() {
		return "解析 [IMEI=" + IMEI + ", IP=" + IP + "]";
	}

}
