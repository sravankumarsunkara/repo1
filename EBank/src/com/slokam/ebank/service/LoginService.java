package com.slokam.ebank.service;

import com.slokam.ebank.dao.LoginDAO;
import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;

public class LoginService {

	private LoginDAO loginDAO;

	public void setLoginDAO(LoginDAO loginDAO) 
	{
	this.loginDAO = loginDAO;
    }

 public UserPojo verifyUser(String username,String password) throws EBankException
 {
	UserPojo result=null; 
	
	try {
		result= loginDAO.verifyUser(username,password);
	} catch (EBankException e) {
		throw e;
	}
	return result;
}
public void regisUser(UserPojo userPojo)throws EBankException
{
	try
	{
	loginDAO.regisUser(userPojo);
	}
	catch(EBankException e)
	{
		throw e;
	}
}
public void updateUser(UserPojo userPojo)throws EBankException
{
	
	try
	{
		loginDAO.updateUser(userPojo);
	}
	catch(EBankException e)
	{
		throw e;
	}
}
public void deleteUser(UserPojo userPojo)throws EBankException
{
	try
	{
		loginDAO.deleteUser(userPojo);
	}
	catch(EBankException e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw new EBankException(e.getMessage());
	}
}
}
