package com.yzx.factory;

public class FruitGardener {

	public static Fruit getFruit(String name)
	{
		
		if("apple".equals(name))
		{
			return new Apple();
		}else if("grape".equals(name))
		{
			return new Grape();
		}	
		return null;
	}
}
