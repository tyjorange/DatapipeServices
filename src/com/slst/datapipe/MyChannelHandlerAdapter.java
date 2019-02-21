package com.slst.datapipe;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slst.datapipe.coder.MsgDecoder;
import com.slst.datapipe.coder.MsgEncoder;
import com.slst.datapipe.dao.pojo.TConnectterm;
import com.slst.datapipe.dao.pojo.TTerm;
import com.slst.datapipe.msg.decode.Bean_TermInfo;
import com.slst.datapipe.util.ByteUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * socket连接事件处理类
 * 
 * @author tyj
 *
 */
@Component
@Scope("prototype")
@Sharable
public class MyChannelHandlerAdapter extends SimpleChannelInboundHandler<ByteBuf> {
	private static Logger logger = Logger.getLogger(MyChannelHandlerAdapter.class);
	@Autowired
	private DatapipeServerCore datapipeServerCore;
	@Autowired
	private MsgDecoder decoder;
	@Autowired
	private MsgEncoder encoder;
	@Resource
	private HashMap<String, ChannelHandlerContext> ctxmap;
	@Resource
	private HashMap<String, Long> timemap;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("[" + ctx.channel().remoteAddress() + "] 连接");
	}

//	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		byte[] msg_byte = (byte[]) msg;
//		if (msg_byte.length < 10) {
//			logger.info("[" + ctx.channel().remoteAddress() + "] 消息错误");
//			logger.info(ByteUtil.printHexString(msg_byte));
//			return;
//		}
//		logger.info("[" + ctx.channel().remoteAddress() + "] 消息 : ");
//		logger.info(ByteUtil.printHexString(msg_byte));
//		if (msg_byte[4] == 0x02 && msg_byte[5] == 0x01) {// 0x0201
//			Bean_TermInfo fromClient = decoder.decodeTermInfo2(msg_byte);
//			short sum = fromClient.getSum();
//			byte[] check_sum = new byte[2];
//			ByteUtil.putShort(check_sum, ByteUtil.byteSumCheck(msg_byte, 4), 0);
//			if (sum != ByteUtil.getShort(check_sum, 0)) {
//				logger.info("[" + fromClient.getIMEI() + "]效验和错误");
//				return;
//			}
//			logger.info(fromClient.toString());
//			ChannelHandlerContext context = ctxmap.get(fromClient.getIMEI());
//			if (context == null || context != ctx) {// 首次,或断线后重连
//				ctxmap.put(fromClient.getIMEI(), ctx);
//				TTerm tTerm = datapipeServerCore.findOrUpdateTerm(fromClient.getIMEI(), fromClient.getIP());
//				if (tTerm == null || tTerm != null) {
//					this.send(fromClient.getIMEI());
//				}
//			} else {
//				TTerm tTerm = datapipeServerCore.findOrUpdateTerm(fromClient.getIMEI(), fromClient.getIP());
//				Long tempTime = timemap.get(fromClient.getIMEI());
//				long cfg_time1 = tempTime == null ? 0 : tempTime;
//				long cfg_time2 = datapipeServerCore.findCfgtimeByImei(fromClient.getIMEI());
//				if (tTerm != null) {// IP改变
//					this.send(tTerm.getImei());
//				} else if (tTerm == null && cfg_time1 != cfg_time2) {// IP未改变,但连接配置时间改变
//					this.send(fromClient.getIMEI());
//				}
//			}
//			logger.info("当前连接数 : " + ctxmap.size());
//		}
//	}

	/**
	 * 群发信息
	 * 
	 * @param imei
	 *            当前Client IMEI
	 */
	private void send(String imei) {
		List<TConnectterm> list = datapipeServerCore.findAllImeiByImei(imei);
		for (TConnectterm ct : list) {
			String list_imei = ct.getTerm().getImei();
			Long list_configtime = ct.getConnect().getConfigtime();
			timemap.put(list_imei, list_configtime);// 更新cfgTime
			ByteBuf msgByImei = datapipeServerCore.initMsgByImei(list_imei);
			ChannelHandlerContext cctx = ctxmap.get(list_imei);
			if (cctx != null) {
				this.sendByteMsg(cctx, msgByImei);
				logger.info("[" + list_imei + "] 已发送");
			} else {
				logger.info("[" + list_imei + "] 未发送");
			}
		}
	}

	/**
	 * 发送一条信息
	 * 
	 * @param ctx
	 *            连接对象
	 * @param res
	 *            内容
	 */
	private void sendByteMsg(ChannelHandlerContext ctx, ByteBuf message) {
		if (message != null && ctx != null) {
			ctx.writeAndFlush(message);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		Collection<ChannelHandlerContext> c = ctxmap.values();
		if (c.contains(ctx)) {
			c.remove(ctx);
			logger.info("当前连接数 : " + ctxmap.size());
		}
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf arg1) throws Exception {
//		byte[] msg_byte = (byte[]) msg;
		byte[] msg_byte = arg1.array();
		if (msg_byte.length < 10) {
			logger.info("[" + ctx.channel().remoteAddress() + "] 消息错误");
			logger.info(ByteUtil.printHexString(msg_byte));
			return;
		}
		logger.info("[" + ctx.channel().remoteAddress() + "] 消息 : ");
		logger.info(ByteUtil.printHexString(msg_byte));
		if (msg_byte[4] == 0x02 && msg_byte[5] == 0x01) {// 0x0201
			Bean_TermInfo fromClient = decoder.decodeTermInfo2(msg_byte);
			short sum = fromClient.getSum();
			byte[] check_sum = new byte[2];
			ByteUtil.putShort(check_sum, ByteUtil.byteSumCheck(msg_byte, 4), 0);
			if (sum != ByteUtil.getShort(check_sum, 0)) {
				logger.info("[" + fromClient.getIMEI() + "]效验和错误");
				return;
			}
			logger.info(fromClient.toString());
			ChannelHandlerContext context = ctxmap.get(fromClient.getIMEI());
			if (context == null || context != ctx) {// 首次,或断线后重连
				ctxmap.put(fromClient.getIMEI(), ctx);
				TTerm tTerm = datapipeServerCore.findOrUpdateTerm(fromClient.getIMEI(), fromClient.getIP());
				if (tTerm == null || tTerm != null) {
					this.send(fromClient.getIMEI());
				}
			} else {
				TTerm tTerm = datapipeServerCore.findOrUpdateTerm(fromClient.getIMEI(), fromClient.getIP());
				Long tempTime = timemap.get(fromClient.getIMEI());
				long cfg_time1 = tempTime == null ? 0 : tempTime;
				long cfg_time2 = datapipeServerCore.findCfgtimeByImei(fromClient.getIMEI());
				if (tTerm != null) {// IP改变
					this.send(tTerm.getImei());
				} else if (tTerm == null && cfg_time1 != cfg_time2) {// IP未改变,但连接配置时间改变
					this.send(fromClient.getIMEI());
				}
			}
			logger.info("当前连接数 : " + ctxmap.size());
		}
	}
}
