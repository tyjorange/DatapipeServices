package com.slst.datapipe.listener;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.slst.datapipe.DatapipeServer;

/**
 * 
 * @author tyj
 *
 */
public class MyListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(MyListener.class);
	private DatapipeServer datapipeServer;
	private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (singleThreadPool != null) {
			logger.info("Trying to stop datapipeThread...");
			try {
				datapipeServer.stop();
				immolate();
				singleThreadPool.shutdown();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		datapipeServer = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(DatapipeServer.class);
		logger.info("Trying to start datapipeThread...");
		try {
			singleThreadPool.execute(datapipeServer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 
	 * @return
	 */
	private Integer immolate() {
		int count = 0;
		try {
			final Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
			threadLocalsField.setAccessible(true);
			final Field inheritableThreadLocalsField = Thread.class.getDeclaredField("inheritableThreadLocals");
			inheritableThreadLocalsField.setAccessible(true);
			for (final Thread thread : Thread.getAllStackTraces().keySet()) {
				count += clear(threadLocalsField.get(thread));
				count += clear(inheritableThreadLocalsField.get(thread));
				if (thread != null) {
					thread.setContextClassLoader(null);
				}
			}
			logger.info("immolated " + count + " values in ThreadLocals");
		} catch (Exception e) {
			throw new Error("ThreadLocalImmolater.immolate()", e);
		}
		return count;
	}

	/**
	 * 
	 * @param threadLocalMap
	 * @return
	 * @throws Exception
	 */
	private int clear(final Object threadLocalMap) throws Exception {
		if (threadLocalMap == null)
			return 0;
		int count = 0;
		final Field tableField = threadLocalMap.getClass().getDeclaredField("table");
		tableField.setAccessible(true);
		final Object table = tableField.get(threadLocalMap);
		for (int i = 0, length = Array.getLength(table); i < length; ++i) {
			final Object entry = Array.get(table, i);
			if (entry != null) {
				final Object threadLocal = ((WeakReference<?>) entry).get();
				if (threadLocal != null) {
					Array.set(table, i, null);
					++count;
				}
			}
		}
		return count;
	}
}
