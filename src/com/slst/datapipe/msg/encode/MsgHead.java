package com.slst.datapipe.msg.encode;

import org.springframework.stereotype.Component;

import com.slst.datapipe.util.ByteUtil;

/**
 * 
 * @author tyj
 *
 */
@Component
public class MsgHead {
	/* 消息头 */
	final byte[] MARK_HEAD = { 0x24, 0x24 };// 2
	/* 消息长度 */
	byte[] msg_lenth;// 2
	/* 消息体 */
	byte[] msg_body;
	/* 检验码 */
	byte[] check_sum;// 2
	/* 消息尾 */
	final byte[] MARK_END = { 0x0D, 0x0A };// 2

	public void setMsg_lenth(byte[] msg_lenth) {
		this.msg_lenth = msg_lenth;
	}

	public void setMsg_body(byte[] msg_body) {
		this.msg_body = msg_body;
	}

	public byte[] get() {
		byte[] b1 = ByteUtil.byteMerger(MARK_HEAD, msg_lenth);
		byte[] b2 = ByteUtil.byteMerger(b1, msg_body);
		short value = ByteUtil.byteSumCheck(b2, 0);
		byte[] check_sum = new byte[2];
		ByteUtil.putShort(check_sum, value, 0);
		byte[] b3 = ByteUtil.byteMerger(b2, check_sum);
		byte[] b4 = ByteUtil.byteMerger(b3, MARK_END);
		return b4;
	}

}
