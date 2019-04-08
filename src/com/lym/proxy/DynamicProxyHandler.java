package com.lym.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *  @description 动态代理
 */
public class DynamicProxyHandler implements InvocationHandler{
	
	private Object realObject;
	 
    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }
 
    @Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理扩展逻辑
        System.out.println("Dynamic proxy do");

        return method.invoke(realObject, args);
    }

}
