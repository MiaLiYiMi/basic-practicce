package com.lym.pattern.factoryDemo.simple;

//女蜗造人
public class Goddess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HumanFactory hf=new ManFactory();
		Human human=hf.creatHuman();
		human.eat();
      human.sleep();
      human.talk();
	}

}
