package com.slst.datapipe.msg.decode;

/**
 * 消息头BEAN
 * 
 * @author tyj
 *
 */
public class BeanHead {
	String msg_head;
	String msg_length;
	IBean msg_body;
	String cheak_sum;
	String msg_end;

	public void setMsg_head(String msg_head) {
		this.msg_head = msg_head;
	}

	public void setMsg_length(String msg_length) {
		this.msg_length = msg_length;
	}

	public void setMsg_body(IBean msg_body) {
		this.msg_body = msg_body;
	}

	public void setCheak_sum(String cheak_sum) {
		this.cheak_sum = cheak_sum;
	}

	public void setMsg_end(String msg_end) {
		this.msg_end = msg_end;
	}

	public String getMsg_head() {
		return msg_head;
	}

	public String getMsg_length() {
		return msg_length;
	}

	public IBean getMsg_body() {
		return msg_body;
	}

	public String getCheak_sum() {
		return cheak_sum;
	}

	public String getMsg_end() {
		return msg_end;
	}

}
