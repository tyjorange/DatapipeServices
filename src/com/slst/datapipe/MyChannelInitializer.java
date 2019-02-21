package com.slst.datapipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slst.datapipe.coder.MyByteArrayDecoder;
import com.slst.datapipe.coder.MyByteArrayEncoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * IO事件处理类
 * 
 * @author tyj
 */
@Component
@Scope("prototype")
@Sharable
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Autowired
	private MyByteArrayDecoder decoder;
	@Autowired
	private MyByteArrayEncoder encoder;
	@Autowired
	private MyChannelHandlerAdapter adpater;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("bytesDecoder", decoder);
		ch.pipeline().addLast("bytesEncoder", encoder);
		ch.pipeline().addLast("adpater", adpater);
	}
}
