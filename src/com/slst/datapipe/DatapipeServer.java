package com.slst.datapipe;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 
 * @author tyj
 *
 */
public class DatapipeServer implements Runnable {
	private static Logger logger = Logger.getLogger(DatapipeServer.class);
	@Autowired
	private LoggingHandler loggingHandler;
	@Autowired
	private NioEventLoopGroup bossGroup;
	@Autowired
	private NioEventLoopGroup workerGroup;
	@Autowired
	private ServerBootstrap bootstrap;
	@Autowired
	private MyChannelInitializer initializer;

	private static int LOCAL_PORT;

	public static void setLOCAL_PORT(int lOCAL_PORT) {
		LOCAL_PORT = lOCAL_PORT;
	}

	private void bind(final int LOCAL_PORT) throws Exception {
		try {
			bootstrap.group(bossGroup, workerGroup);
			bootstrap.handler(loggingHandler);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.option(ChannelOption.TCP_NODELAY, true);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.childHandler(initializer);
			bootstrap.bind(LOCAL_PORT).channel().closeFuture().awaitUninterruptibly();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	@Override
	public void run() {
		try {
			bind(LOCAL_PORT);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void stop() throws Exception {
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
}
