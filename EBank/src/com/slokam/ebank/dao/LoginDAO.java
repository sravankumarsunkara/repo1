package com.slokam.ebank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Annotation;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;
import com.slokam.ebank.util.HibernateUtil;
//import com.slokam.ebank.util.DBUtil;
import com.slokam.ebank.util.JNDIUtil;

public class LoginDAO {
	private DataSource ds;
	private SessionFactory sf;
	private JdbcTemplate jdbcTemplate;
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


    public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	/*Connection con=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;*/
	public UserPojo verifyUser(String username,String password)throws EBankException{

	/*try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gts","opengts");
		//con=JNDIUtil.getConnection();
		con=ds.getConnection();
		pstmt=con.prepareStatement("Select * from gts.login where username=? and password=?");
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		rs=pstmt.executeQuery();
		result=new UserPojo();
		if(rs.next())
		{
			result.setId(rs.getInt("id"));
			result.setUserName(rs.getString("UserName"));
			result.setBalance(rs.getFloat("balance"));
			result.setPassword(rs.getString("password"));
			result.setStatus(rs.getString("status"));
			result.setRole(rs.getString("role"));
		System.out.println(result);
		}
		
	
	} catch (ClassNotFoundException e) {
		throw new EBankException("No such jar found");
	}
	catch(SQLException s)
	{
		throw new EBankException("Table(login) doesnot exist");
	}
	finally
	{
		try
		{
		if(rs!=null)rs.close();
		if(rs!=null)pstmt.close();
		if(rs!=null)con.close();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}*/
	String query="select * from login where username=? and password=? ";
	UserPojo pojo=jdbcTemplate.queryForObject(query, new UserRowMapper(),username,password);
	return pojo;
	}
	
	
	
	
	
	/**
	 * @param userPojo
	 * @throws EBankException
	 */
	/**
	 * @param userPojo
	 * @throws EBankException
	 */
	public void regisUser(UserPojo userPojo)throws EBankException
	{
		/*Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;*/
		try
		{
			//Configuration cfg= new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		//SessionFactory sf=cfg.buildSessionFactory();*/
		
			/*con=JNDIUtil.getConnection();
			pstmt=con.prepareStatement("insert into login(username,password,role,status,balance) values(?,?,?,?,?)");
	        pstmt.setString(1,userPojo.getUserName());
	        pstmt.setString(2,userPojo.getPassword());
	        pstmt.setString(3,userPojo.getRole());
	        pstmt.setString(4,userPojo.getStatus());
	        pstmt.setFloat(5,userPojo.getBalance());
	        //pstmt.setInt(6,userPojo.getId());
	        pstmt.executeUpdate();*/
	    /*Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(userPojo);
		tx.commit();
		session.close();*/
			/*String query="insert into login(username,password,role,status,balance) values(?,?,?,?,?)";
			Object[] params={userPojo.getUserName(),userPojo.getPassword(),userPojo.getRole(),userPojo.getStatus(),userPojo.getBalance()};
			jdbcTemplate.update(query,params);*/
			hibernateTemplate.save(userPojo);
			
			
		}
		catch(Exception s)
		{
			throw new EBankException(s.getMessage());
		}
		/*finally
		{
			try
			{
				if(con!=null) con.close();
				if(pstmt!=null)pstmt.close();
			    if(rs!=null)rs.close();
			}
			catch(SQLException e)
			{
				
			}
		}*/
		
	}
	public void updateUser(UserPojo userPojo)throws EBankException
	{
		try
		{
			/*Configuration cfg= new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();*/
			
		//Session session=HibernateUtil.getSession();
		/*Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(userPojo);
		tx.commit();
		session.close();*/
			/*String query="update login set username=?,password=?,role=?,status=?,balance=? where id=?";
		    Object[] params={userPojo.getUserName(),userPojo.getPassword(),userPojo.getRole(),userPojo.getStatus(),userPojo.getBalance(),userPojo.getId()};
		    jdbcTemplate.update(query,params);*/
			hibernateTemplate.update(userPojo);
			
		}
		catch(Exception s)
		{
			throw new EBankException("Hibernate Exception");
		}
	
	}
	public void deleteUser(UserPojo userPojo)throws EBankException
	{
		try
		{
/*//			Configuration cfg= new AnnotationConfiguration().configure("hibernate.cfg.xml");
//		
//		SessionFactory sf=cfg.buildSessionFactory();
 * 
*/		
		//Session session=HibernateUtil.getSession();
	    /*Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(userPojo);
		tx.commit();
		session.close();*/
		/*String query="delete from login where id=?";
		jdbcTemplate.update(query,userPojo.getId());*/
			hibernateTemplate.delete(userPojo);
		}
		catch(Exception s)
		{
			throw new EBankException(s.getMessage());
		}
	
	}
	public static void main1(String args[])
	{
		try
		{
		LoginDAO dao=new LoginDAO();
		UserPojo pojo=new UserPojo();
		//pojo.setId(20);
		pojo.setUserName("xyz");
		pojo.setPassword("abc");
		pojo.setRole("user");
		pojo.setStatus("active");
		pojo.setBalance(1234.56f);
		dao.regisUser(pojo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main2(String args[])
	{
		try
		{
		LoginDAO dao=new LoginDAO();
		UserPojo pojo=new UserPojo();
		pojo.setId(10);
		pojo.setUserName("wyz");
		pojo.setPassword("bcd");
		pojo.setRole("user");
		pojo.setStatus("active");
		pojo.setBalance(1234.56f);
		dao.updateUser(pojo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main(String args[])
	{
		try
		{
		LoginDAO dao=new LoginDAO();
		UserPojo pojo=new UserPojo();
		pojo.setId(11);
		
		dao.deleteUser(pojo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
class UserRowMapper implements RowMapper<UserPojo>
{
	public UserPojo mapRow(ResultSet rs,int arg1)
	{
		UserPojo pojo= new UserPojo();
		try
		{
		pojo.setId(rs.getInt("id"));
		pojo.setUserName(rs.getString("UserName"));
		pojo.setBalance(rs.getFloat("balance"));
		pojo.setPassword(rs.getString("password"));
		pojo.setStatus(rs.getString("status"));
		pojo.setRole(rs.getString("role"));
		
		}
		catch(SQLException e)
		{
			
		}
		return pojo;
		
	}
}
