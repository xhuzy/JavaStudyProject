package com.youyou.dynamicProxy.invacationHandler;

import java.lang.reflect.Method;

import com.youyou.dynamicProxy.log.Log;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zz
 * 
 * cglib is faster than jdk dynamic-proxy but cglib is slower than jdk dynamic-proxy when create proxy object
 * 
 * so cglib type is more useful in sigonle type
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Enhancer hancer = new Enhancer();

	public Object getProxy(Class clazz) {
		this.hancer.setSuperclass(clazz);
		this.hancer.setCallback(this);
		return this.hancer.create();

	}

	@Override
	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
		Log.WriteLog("开始记录入参,方法"+method.getName());
		for (Object param : arg) {
			Log.WriteLog(param.toString());
		}
		Object result = proxy.invokeSuper(obj, arg);
		Log.WriteLog(result.toString());

		return result;
	}

}
