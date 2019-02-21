package com.slst.datapipe.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.bytes.ByteArrayDecoder;

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
public class MyByteArrayDecoder extends ByteArrayDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		super.decode(ctx, msg, out);
	}

}
