package com.youyou.aspectj.service.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreServiceAopLogic {
	@Before("execution(* service(..))")
	public void beforeService() {
		System.out.println("before service you need to do somethings");
	}
}
