package com.youyou.dynamicProxy.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	private static Logger logger;

	static {
		String filePath = Log.class.getClassLoader().getResource("com/youyou/dynamicProxy/config/log4j.properties")
				.getPath();
		PropertyConfigurator.configure(filePath);
		logger = Logger.getLogger(Logger.class);
	}

	public static void WriteLog(String logContext) {
		try {
			logger.debug(logContext);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

}
