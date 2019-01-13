package com.slokam.ebank.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDIUtil {
	private static DataSource ds;
	static
	{
		try {
			InitialContext ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:comp/env/jdbc/gtsds");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection()
	{
	  Connection con=null;
	  try {
		con=ds.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return con;
	}

}
