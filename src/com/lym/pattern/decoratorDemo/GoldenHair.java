package com.lym.pattern.decoratorDemo;

public class GoldenHair extends GirlDecorator{

	private Girl girl;
	public GoldenHair(Girl girl) {
		 this.girl=girl;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return girl.getDescription()+"+with golden hair";
	}

}
