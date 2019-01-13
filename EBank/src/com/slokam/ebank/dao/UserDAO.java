package com.slokam.ebank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.TransactionPojo;
import com.slokam.ebank.pojo.UserPojo;
import com.slokam.ebank.util.HibernateUtil;
import com.slokam.ebank.util.JNDIUtil;

public class UserDAO {
	private SessionFactory sf;
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public UserPojo getUserInfo(Integer id) throws EBankException
	{
		
		/*Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserPojo userPojo=null;
		Collection<TransactionPojo> txCol=new ArrayList<TransactionPojo>(); 
		try{
		con=JNDIUtil.getConnection();
		pstmt=con.prepareStatement("select * from login l left join transaction t on l.id=t.userid where l.id=?");
		System.out.println("select * from login l left join transaction t on l.id=t.userid where l.id=?" + id);
		pstmt.setInt(1,id);
		rs=pstmt.executeQuery();
		int i=1;
		while(rs.next())
		{
		if(i==1)
		{
			userPojo=new UserPojo();
			userPojo.setUserName(rs.getString("username"));
			userPojo.setId(rs.getInt("id"));
			userPojo.setBalance(rs.getFloat("balance"));
			userPojo.setStatus(rs.getString("status"));
		}
		i++;
		TransactionPojo tPojo=new TransactionPojo();
		tPojo.setBankName(rs.getString("bankname"));
		tPojo.setBankAccNo(rs.getInt("bankAccNo"));
		tPojo.setAmount(rs.getFloat("amount"));
		tPojo.setDate(rs.getString("tdate"));
		tPojo.setType(rs.getString("type"));
		tPojo.setUserId(rs.getInt("userId"));
		txCol.add(tPojo);
		}
	    userPojo.setTxCol(txCol);
		} catch (SQLException e) {
		throw new EBankException(e.getMessage());
		}
		finally{
			try {
				if(rs!=null)
				rs.close();
			if(pstmt!=null)
			pstmt.close();
			
			if(con!=null)
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/	
		//Session session =HibernateUtil.getSession();
				Session session=sf.openSession();
				UserPojo userPojo=(UserPojo)session.get(UserPojo.class, id);
				Collection<TransactionPojo> txPojo= userPojo.getTxCol();
				System.out.println(txPojo.isEmpty());
				userPojo.setTxCol(txPojo);
				session.close();
		//UserPojo userPojo= (UserPojo) hibernateTemplate.get(UserPojo.class, id);
		return userPojo;
	}
	public UserPojo getUserDetails(Integer id)throws EBankException
	{
		/*Configuration cfg=new AnnotationConfiguration().configure();
		SessionFactory sf=cfg.buildSessionFactory();*/
		//Session session=HibernateUtil.getSession();
		/*Session session=sf.openSession();
		UserPojo pojo=null;
	    try
	    {
		pojo=(UserPojo)session.get(UserPojo.class, id);
		session.close();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    	throw new EBankException(e.getMessage());
	    }*/
		UserPojo pojo=hibernateTemplate.get(UserPojo.class, id);
		return pojo;
	}

}
