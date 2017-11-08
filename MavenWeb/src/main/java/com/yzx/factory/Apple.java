package com.yzx.factory;

import org.apache.log4j.Logger;

public class Apple implements Fruit{

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void harverst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void plant() {
		// TODO Auto-generated method stub
		
	}

	static Logger logger = Logger.getLogger(Apple.class);
	public static void main(String[] args)
	{
		logger.info("123");
	}
}
