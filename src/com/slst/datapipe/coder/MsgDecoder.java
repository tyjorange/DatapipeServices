package com.slst.datapipe.coder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slst.datapipe.msg.decode.Bean_TermInfo;

/**
 * 十六进制信息解析
 * 
 * @author tyj
 *
 */
@Component
public class MsgDecoder {
	@Autowired
	private Bean_TermInfo info;

	/**
	 * 解析终端上传信息
	 * 
	 * @param hex_msg
	 *            接收到的16进制消息
	 * @return IMEI IP
	 */
	// public Bean_TermInfo decodeTermInfo(byte[] hex_msg) {
	// try {
	// byte s1[] = new byte[15];
	// System.arraycopy(hex_msg, 6, s1, 0, 15);
	// sbf.append(new String(s1));
	// // for (int a = 6; a <= 20; a++) {
	// // byte b = hex_msg[a];
	// //
	// // String bcd2Str = ByteUtil.bcd2Str(new byte[] { b });
	// // sbf.append(new String(s));
	// // }
	// info.setIMEI(sbf.toString());
	// sbf.delete(0, sbf.length());
	// byte s2[] = new byte[4];
	// System.arraycopy(hex_msg, 21, s2, 0, 4);
	// sbf.append(ByteUtil.getInt(s2, 0));
	// // for (int a = 21; a <= 24; a++) {
	// // byte b = hex_msg[a];
	// // Integer s2 = Integer.valueOf(b & 0xFF);
	// // sbf.append(s2);
	// // }
	// // body.setIP(sbf.toString());
	// sbf.delete(0, sbf.length());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return info;
	// }
	/**
	 * 解析终端上传信息
	 * 
	 * @param hex_msg
	 *            接收到的16进制消息
	 * @return IMEI IP SUM
	 */
	public Bean_TermInfo decodeTermInfo2(byte[] hex_msg) {
		ByteBuf message = Unpooled.buffer(hex_msg.length).writeBytes(hex_msg);
		ByteBuf imei = message.copy(6, 15);
		info.setIMEI(new String(imei.array()));
		int ip = message.getInt(21);
		info.setIP(ip);
		short sum = message.getShort(hex_msg.length - 4);
		info.setSum(sum);
		return info;
	}

}
