package com.slst.datapipe.coder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * 
 * @author tyj
 *
 */
@Component
@Scope("prototype")
@Sharable
public class MyByteArrayEncoder extends ByteArrayEncoder {

	@Override
	protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
		super.encode(ctx, msg, out);
	}

}
