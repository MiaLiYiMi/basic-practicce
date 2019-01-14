package com.lym.pattern.factoryDemo.abstracte;

//具体工厂
public class Akitchen implements KitchenFactory{
	@Override
	public Food getFood() {
		return new Apple();
	}
	
	@Override
	public TableWare getTableWare() {
		return new Knife();
	}
}
