package com.lym.proxy;

import org.junit.jupiter.api.Test;

/**
 * 
 * @description 静态代理测试类
 *
 */
class ProxyTest {

	@Test
	void test() {
		System.out.println("Statis ------>");
		StaticProxy proxy = new StaticProxy(new RealObject());
	    proxy.doSth();
	   }

}
