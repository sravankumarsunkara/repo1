package com.slokam.ebank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;
import com.slokam.ebank.util.HibernateUtil;
import com.slokam.ebank.util.JNDIUtil;

public class AdminDAO {
	private SessionFactory sf;
	private JdbcTemplate jdbcTemplate;
	
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
public Collection<UserPojo> getUsers() throws EBankException
{
	
    /*Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ArrayList<UserPojo> al=new ArrayList<UserPojo>();
    try
    {
    con=JNDIUtil.getConnection();
    String query="select * from login where role=?";
	pstmt=con.prepareStatement(query);
	pstmt.setString(1, "user");
	rs=pstmt.executeQuery();
	if(rs.next())
	{		
		do
		{
			UserPojo userPojo=new UserPojo();
			userPojo.setId(rs.getInt("Id"));
			userPojo.setUserName(rs.getString("username"));
			userPojo.setStatus(rs.getString("status"));
			userPojo.setBalance(rs.getFloat("balance"));
			al.add(userPojo);
		}while(rs.next());
	}
	} catch (SQLException e) {
     throw new EBankException("check your query and columns");
	}
    finally
    {
       try
        {
    	 if(rs!=null)
			rs.close();			
    	 if(pstmt!=null)
    		pstmt.close();
    	 if(con!=null)
    		con.close();
        }
       catch(SQLException e)
       {
    	   e.printStackTrace();
       }
    	
    }
*/	
	//Session session=HibernateUtil.getSession();
	/*Session session=sf.openSession();
	Query query=session.createQuery("from UserPojo");
	Collection<UserPojo> userPojo=query.list();
	session.close();*/
	String query="select * from login where role=?";
	Collection<UserPojo> userPojo= jdbcTemplate.query(query, new UserRowMapper1(),"user");
	return userPojo;
}
public Collection<UserPojo> similarUser(String userName) throws EBankException
{
	
	/*Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<UserPojo> al=new ArrayList<UserPojo>();
	try
	{
	con=JNDIUtil.getConnection();
		pstmt=con.prepareStatement("select * from login where username like ? and role=?");
		System.out.println(userName);
		pstmt.setString(1, userName+"%");
		pstmt.setString(2,"user");
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			do{
				UserPojo userPojo=new UserPojo();
				userPojo.setUserName(rs.getString("username"));
				userPojo.setId(rs.getInt("id"));
				userPojo.setBalance(rs.getFloat("balance"));
				userPojo.setStatus(rs.getString("status"));
				al.add(userPojo);
			}while(rs.next());
		}
	} catch (SQLException e) {
		throw new EBankException("check your query");
	}
	finally
	{
		try
		{
			if(con!=null)
				con.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
*/	
	//Session session=HibernateUtil.getSession();
		/*Session session=sf.openSession();
		Query query=session.createQuery("from UserPojo where userName like :userName");
		query.setString("userName", userName+"%");
		Collection<UserPojo> userPojo=query.list();
		session.close();*/
	    String query="select * from login where username like ? and role=?";
	    Collection<UserPojo> userPojo=jdbcTemplate.query(query, new UserRowMapper(),userName+"%","user"); 
	return userPojo;
}
}
class UserRowMapper1 implements RowMapper<UserPojo>
{
	public UserPojo mapRow(ResultSet rs,int arg1)throws SQLException
	{
		UserPojo userPojo=new UserPojo();
		userPojo.setUserName(rs.getString("username"));
		userPojo.setId(rs.getInt("id"));
		userPojo.setBalance(rs.getFloat("balance"));
		userPojo.setStatus(rs.getString("status"));
		return userPojo;
	}
}
