package com.youyou.dynamicProxy.invacationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.youyou.dynamicProxy.log.Log;

public class CaculateInvacationHandler implements InvocationHandler {

	private Object target;

	public CaculateInvacationHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Log.WriteLog("开始记录入参");
		for (Object param : args) {
			Log.WriteLog(param.toString());
		}
		Object result = method.invoke(this.target, args);
		Log.WriteLog(result.toString());
		
		return result;
	}

}
