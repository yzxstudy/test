package com.yzx.dao;

import org.apache.commons.dbcp.BasicDataSource;

public abstract class BaseDao {

	
	public  static BasicDataSource ds;
	
//	static 
//	{
//		ds = new BasicDataSource();
//		ds.setInitialSize(5);
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/xuexiao?&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false");
//		ds.setUsername("root");
//		ds.setPassword("1234");
//	}
	
	
	static 
	{
		ds = new BasicDataSource();
		ds.setInitialSize(5);
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		ds.setUsername("gxy");
		ds.setPassword("123456");
	}
	
}
