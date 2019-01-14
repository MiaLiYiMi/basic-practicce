package com.lym.pattern.factoryDemo.abstracte;

//抽象工厂
public interface KitchenFactory {
	public Food getFood();
	public TableWare getTableWare();
}
