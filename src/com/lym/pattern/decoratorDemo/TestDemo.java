package com.lym.pattern.decoratorDemo;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Girl girl=new AmericanGirl();
		System.out.println(girl.getDescription());
		Girl girl2=new GoldenHair(girl);
		System.out.println(girl2.getDescription());
		Girl girl3=new Tall(girl2);
		System.out.println(girl3.getDescription());
		
		Girl girl4=new Tall(new GoldenHair(new AmericanGirl()));
		System.out.println(girl4.getDescription());
	}

}
