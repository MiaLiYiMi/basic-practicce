package com.lym.proxy;

/**
 *  @description 代理对象
 */
public class StaticProxy implements CommonAction{
	
	private CommonAction realObject;
	
	public StaticProxy(CommonAction realObject) {
        this.realObject = realObject;
    }
	
	@Override
    public void doSth() {
        System.out.println("static proxy do...");
        realObject.doSth();
    }

}
