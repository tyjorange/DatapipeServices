package com.slst.datapipe.msg.encode;

import java.util.List;

import org.springframework.stereotype.Component;

import com.slst.datapipe.dao.pojo.TConnectterm;
import com.slst.datapipe.util.ByteUtil;
/**
 * 
 * @author tyj
 *
 */
@Component
public class MsgBody_ChanneInfo {
	final byte[] msg_id = { 0x02, 0x02 };// 2
	byte[] socket_model;// 1
	byte[] socket_port;// 2
	byte[] time;// 8
	byte[] pipe_count;// 2
	byte[] pipe_ip_all;
	byte[] cryptkey;// 16

	public void setSocket_model(int model) {
		this.socket_model = new byte[] { ByteUtil.putInt(model)[1] };
	}

	public void setSocket_port(int port) {
		this.socket_port = ByteUtil.putInt(port);
	}

	public void setTime(long time) {
		byte[] all = new byte[8];
		ByteUtil.putLong(all, time, 0);
		this.time = all;
	}

	public void setPipe_count(int size) {
		this.pipe_count = ByteUtil.putInt(size);
	}

	public void setPipe_ip_all(List<TConnectterm> list) {
		byte[] all = {};
		for (TConnectterm tc : list) {
			all = ByteUtil.byteMerger(all, ByteUtil.putLong(tc.getTerm().getIp()));
		}
		this.pipe_ip_all = all;
	}

	public void setCryptkey(String s) {
		this.cryptkey = s.getBytes();
	}

	public byte[] get() {
		byte[] b1 = ByteUtil.byteMerger(msg_id, socket_model);
		byte[] b2 = ByteUtil.byteMerger(b1, socket_port);
		byte[] b3 = ByteUtil.byteMerger(b2, time);
		byte[] b4 = ByteUtil.byteMerger(b3, pipe_count);
		byte[] b5 = ByteUtil.byteMerger(b4, pipe_ip_all);
		byte[] b6 = ByteUtil.byteMerger(b5, cryptkey);
		return b6;
	}
}
