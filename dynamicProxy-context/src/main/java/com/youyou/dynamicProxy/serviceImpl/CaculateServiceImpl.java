package com.youyou.dynamicProxy.serviceImpl;

import java.math.BigDecimal;

import com.youyou.dynamicProxy.service.ICaculateService;

public class CaculateServiceImpl implements ICaculateService {

	public BigDecimal add(BigDecimal num1, BigDecimal num2) {
		
		return num1.add(num2);
	}

	public BigDecimal sub(BigDecimal num1, BigDecimal num2) {
		
		return num1.subtract(num2);
	}

}
