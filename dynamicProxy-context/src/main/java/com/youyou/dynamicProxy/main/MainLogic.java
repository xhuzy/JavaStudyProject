package com.youyou.dynamicProxy.main;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

import org.apache.log4j.chainsaw.Main;

import com.youyou.dynamicProxy.invacationHandler.CaculateInvacationHandler;
import com.youyou.dynamicProxy.invacationHandler.CglibProxy;
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
		
		
		CglibProxy cglib=new CglibProxy();
		ICaculateService cglibProxyCaculate = (ICaculateService) cglib.getProxy(CaculateServiceImpl.class);
		
		BigDecimal num3=new BigDecimal("9.3");
		BigDecimal num4=new BigDecimal("1.7");
		
		BigDecimal addResult3=cglibProxyCaculate.add(num3,num4);
		BigDecimal subResult4=cglibProxyCaculate.sub(num3, num4);
		
		System.out.println(addResult3);
		System.out.println(subResult4);
		
		
		
		
		
	}
}
