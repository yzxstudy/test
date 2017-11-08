package com.yzx.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import com.yzx.bean.Student;

public class TestOracleJdbc {
	public  static BasicDataSource ds;
	
	static 
	{
		ds = new BasicDataSource();
		ds.setInitialSize(5);
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		ds.setUsername("gxy");
		ds.setPassword("123456");
	}
	public static void main(String[] args) throws SQLException {
		
		String sql = "SELECT * from student ";
		Connection conn = ds.getConnection();
		Statement st = conn.createStatement();	
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		
		
	}

}
