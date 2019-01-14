package com.lym.pattern.factoryDemo.simple;

/** 简单工厂模式
 * @author lym
 *
 */
//public class HumanFactory{
//	public static Human creatHuman(String gender) {
//		Human human=null;
//		if(gender.equals("man")){
//			human=new Man();
//		}else if (gender.equals("female")) {
//			human=new Female();
//		}
//		return human;
//	} 
//}

/**
 * 工厂方法模式
 * @author lym
 *
 */
abstract class HumanFactory{
	public abstract Human creatHuman() ;
}

class ManFactory extends HumanFactory{

	@Override
	public Human creatHuman() {
		// TODO Auto-generated method stub
		return new Man();
	}
	
}

class FamaleFactory extends HumanFactory{

	@Override
	public Human creatHuman() {
		// TODO Auto-generated method stub
		return new Female();
	}
	
}
