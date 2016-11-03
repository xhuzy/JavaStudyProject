package com.youyou.aspectj.aspectjTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableServer.POAPackage.WrongAdapterHelper;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyou.aspectj.service.Waiter;
import com.youyou.aspectj.service.aop.PreServiceAopLogic;

public class WaiterTest {

	@Test
	public void testWaiterUseconfig() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:com/youyou/aspectj/test/spring/app-context.xml");
		Waiter waiter = (Waiter) context.getBean("waiter");
		waiter.sayHello("zhaoyong");
		waiter.service("ziang");
	}

	@Test
	public void testWaiterUseProxyFactory() {
		Waiter waiterTarget=new Waiter();
		AspectJProxyFactory factory=new AspectJProxyFactory();
		factory.setTarget(waiterTarget);
		factory.addAspect(PreServiceAopLogic.class);
		Waiter waiter=factory.getProxy();
		waiter.sayHello("zhao");
		waiter.service("yong");
	}

}
