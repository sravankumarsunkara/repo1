package com.slokam.ebank.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtil {
	private static BasicDataSource ds=null;
	static
	{
		ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("gts");
		ds.setPassword("opengts");
	}
	private DBUtil()
	{
		
	}
	public static Connection getConnection()
	{
		Connection con =null;
		try
		{
		con=ds.getConnection();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	
}
