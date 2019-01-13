package com.slokam.ebank.service;

import java.util.Collection;

import com.slokam.ebank.dao.AdminDAO;
import com.slokam.ebank.exception.EBankException;
import com.slokam.ebank.pojo.UserPojo;

public class AdminService {
	private AdminDAO adminDAO;
	public Collection<UserPojo> getUsers() throws EBankException
	{
		Collection<UserPojo> collection;
		
		try {
			collection=adminDAO.getUsers();
		} catch (EBankException e) {
			throw e;
		}
		return collection;
	}
	public Collection<UserPojo> similarUser(String userName)throws EBankException
	{
		Collection<UserPojo> collection;
		
		try
		{
			collection=adminDAO.similarUser(userName);
		}
		catch(EBankException e)
		{
			throw e;
		}
		return collection;
	}
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

}
