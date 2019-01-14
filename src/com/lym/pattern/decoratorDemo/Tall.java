package com.lym.pattern.decoratorDemo;

public class Tall extends GirlDecorator{
	
	private Girl girl;
	
	public Tall(Girl girl) {
		this.girl=girl;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return girl.getDescription()+"+tall";
	}

}
