package com.lym.pattern.factoryDemo.simple;

//抽象产品
abstract class Human {
	public abstract void eat();
	public abstract void sleep();
	public abstract void talk();
}

//具体产品
class Man extends Human{
	@Override
	public void eat(){
		System.out.println("Man can eat.");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Man can sleep.");
	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("Man can talk");
	}
}

class Female extends Human{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Female can eat.");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Female can sleep.");
	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("Female can sleep.");
	}
	
}
