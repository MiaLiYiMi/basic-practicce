package com.lym.proxy;

import java.lang.reflect.Proxy;

/**
 * @description 动态代理测试类
 */
public class DynamicProxyTest {

	public static void main(String[] args) {
		System.out.println("Dynamic ------>");
		RealObject realObject = new RealObject();
		CommonAction proxyNew = (CommonAction) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] { CommonAction.class }, new DynamicProxyHandler(realObject));
		proxyNew.doSth();
	}

}
