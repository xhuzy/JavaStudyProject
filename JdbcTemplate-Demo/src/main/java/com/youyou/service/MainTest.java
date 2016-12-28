package com.youyou.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
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
