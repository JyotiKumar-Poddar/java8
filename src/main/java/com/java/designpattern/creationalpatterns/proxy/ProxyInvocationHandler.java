package com.java.designpattern.creationalpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

	private Object targetObj;

	public ProxyInvocationHandler(Object targetObj) {
		this.targetObj = targetObj;
	}

	public Object getTargetObj() {
		return targetObj;
	}

	public void setTargetObj(Object targetObj) {
		this.targetObj = targetObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long inititalTime = System.currentTimeMillis();
		Object result = method.invoke(targetObj, args);
		System.out.println("Total Time Taken in Execution  "
				+ (System.currentTimeMillis() - inititalTime));
		return result;
	}

}
