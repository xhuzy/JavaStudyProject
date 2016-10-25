package com.youyou.dynamicProxy.main;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

import org.apache.log4j.chainsaw.Main;

import com.youyou.dynamicProxy.invacationHandler.CaculateInvacationHandler;
import com.youyou.dynamicProxy.service.ICaculateService;
import com.youyou.dynamicProxy.serviceImpl.CaculateServiceImpl;

public class MainLogic {
	public static void main(String[] args) {
		ICaculateService caculateService = new CaculateServiceImpl();
		CaculateInvacationHandler calInvocation = new CaculateInvacationHandler(caculateService);

		ICaculateService proxyCaculate = (ICaculateService) Proxy.newProxyInstance(MainLogic.class.getClassLoader(),
				CaculateServiceImpl.class.getInterfaces(), calInvocation);
		BigDecimal num1=new BigDecimal("2.3");
		BigDecimal num2=new BigDecimal("0.7");
		
		BigDecimal addResult=proxyCaculate.add(num1,num2);
		BigDecimal subResult=proxyCaculate.sub(num1, num2);
		
		System.out.println(addResult);
		System.out.println(subResult);
		
		
		
	}
}
