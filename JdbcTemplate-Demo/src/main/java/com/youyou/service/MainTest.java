package com.youyou.service;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class MainTest {

	/**
	 * Ìí¼Ó×Ö¶Î×¢ÊÍ.
	 */
	protected Logger logger = Logger.getLogger(MainTest.class);
	static {
		try {
			Log4jConfigurer.initLogging("classpath:com/youyou/spring/log4j.properties");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.err.println("Cannot Initialize log4j");
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/youyou/spring/app-context.xml");
		try {
			ServiceRouteDao dao = (ServiceRouteDao) context.getBean("serviceDao");
			int i = dao.addServiceroute();
			System.out.println(i);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
