package com.slst.datapipe.coder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slst.datapipe.dao.pojo.TConnectterm;
import com.slst.datapipe.msg.encode.MsgBody_ChanneInfo;
import com.slst.datapipe.msg.encode.MsgHead;
import com.slst.datapipe.util.ByteUtil;

/**
 * 十六进制信息编码
 * 
 * @author tyj
 *
 */
@Component
public class MsgEncoder {
	@Autowired
	private MsgHead msgHead;
	@Autowired
	private MsgBody_ChanneInfo channeInfoBody;
	/* 消息头 */
	final byte[] MARK_HEAD = { 0x24, 0x24 };// 2
	/* 消息ID */
	final byte[] msg_id = { 0x02, 0x02 };// 2
	/* 消息尾 */
	final byte[] MARK_END = { 0x0D, 0x0A };// 2

	/**
	 * 初始化HEX信息[通道信息]
	 * 
	 * @param current
	 *            本端信息 包含IMEI,CID,SOCKETMODE
	 * @param list
	 *            对端信息列表
	 * @return 十六进制串数组
	 */
	public byte[] initChannelInfoMsg(TConnectterm current, List<TConnectterm> list) {
		channeInfoBody.setSocket_model(current.getSocketmode());
		channeInfoBody.setSocket_port(current.getConnect().getPort());
		channeInfoBody.setTime(current.getConnect().getConfigtime());
		channeInfoBody.setPipe_count(list.size());
		channeInfoBody.setPipe_ip_all(list);
		channeInfoBody.setCryptkey(current.getConnect().getCryptkey());
		byte[] cib = channeInfoBody.get();
		msgHead.setMsg_lenth(ByteUtil.putInt(cib.length));
		msgHead.setMsg_body(cib);
		return msgHead.get();
	}

	/**
	 * 初始化HEX信息[通道信息]
	 * 
	 * @param current
	 *            本端信息 包含IMEI,CID,SOCKETMODE
	 * @param list
	 *            对端信息列表
	 * @return Byte数组
	 */
	public ByteBuf initChannelInfoMsg2(TConnectterm current, List<TConnectterm> list) {
		ByteBuf temp = Unpooled.buffer(0);
		temp.writeBytes(msg_id);
		temp.writeByte(current.getSocketmode());
		temp.writeShort(current.getConnect().getPort());
		temp.writeLong(current.getConnect().getConfigtime());
		temp.writeShort(list.size());
		for (TConnectterm tc : list) {
			temp.writeInt(tc.getTerm().getIp());
		}
		temp.writeBytes(current.getConnect().getCryptkey().getBytes());
		ByteBuf msg_body = temp.copy(0, temp.writerIndex());
		ByteBuf msg_head = Unpooled.buffer(0);
		msg_head.writeBytes(MARK_HEAD);
		msg_head.writeShort(msg_body.array().length);
		msg_head.writeBytes(msg_body);
		short sumCheck = ByteUtil.byteSumCheck(msg_head.array(), 0);
		msg_head.writeShort(sumCheck);
		msg_head.writeBytes(MARK_END);
		return msg_head.copy(0, msg_head.writerIndex());
	}

}
