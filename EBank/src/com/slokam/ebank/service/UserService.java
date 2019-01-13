package com.slokam.ebank.service;

import com.slokam.ebank.dao.UserDAO;
import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;

public class UserService {
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public UserPojo getUserInfo(Integer id) throws EBankException
	{
		UserPojo userPojo=null;
		
		try {
			userPojo=userDAO.getUserInfo(id);
		} catch (EBankException e) {
		  throw	e;
		}
		return userPojo;
	}
	public UserPojo getUserDetails(Integer id)throws EBankException
	{
		
		UserPojo userPojo=null;
		try
		{
		userPojo=(UserPojo)userDAO.getUserDetails(id);
		}
		catch(EBankException e)
		{
			throw e;
		}
		return userPojo;
	}

}
