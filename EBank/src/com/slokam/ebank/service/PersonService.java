package com.slokam.ebank.service;

import java.util.List;

import com.slokam.ebank.dao.PersonDAO;
import com.slokam.ebank.pojo.PersonSearchPojo;

public class PersonService {
	private PersonDAO personDAO;
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	public List<Object[]> searchPerson(PersonSearchPojo searchPersonPojo)
	{
		return personDAO.searchPerson(searchPersonPojo);
		
	}

}
