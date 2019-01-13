package com.slokam.ebank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.slokam.ebank.pojo.PersonPojo;
import com.slokam.ebank.pojo.PersonSearchPojo;
import com.slokam.ebank.util.HibernateUtil;

public class PersonDAO {
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Object[]> searchPerson(PersonSearchPojo searchPersonPojo)
	{
/*	Session session=HibernateUtil.getSession();
	String queryStr="select p.name,ppt.no,ph.num,c.name from PersonPojo p join p.passport ppt join p.phone ph join p.course c where 1=1";
	if(searchPersonPojo.getPersonName()!=null && !searchPersonPojo.getPersonName().trim().equals(""))
	{
		queryStr=queryStr+"and p.name like :pname";
	}
	if(searchPersonPojo.getPassportNo()!=null && !searchPersonPojo.getPassportNo().trim().equals(""))
	{
		queryStr=queryStr+"and ppt.no like :pptno";
	}
	if(searchPersonPojo.getPhoneNo()!=null && !searchPersonPojo.getPhoneNo().trim().equals(""))
	{
		queryStr=queryStr+"and ph.num like :phnum";
	}
	if(searchPersonPojo.getCourses()!=null && !searchPersonPojo.getCourses().trim().equals(""))
	{
		queryStr=queryStr+"and c.name like :cname";
	}
	Query query=session.createQuery(queryStr);
	if(searchPersonPojo.getPersonName()!=null && !searchPersonPojo.getPersonName().trim().equals(""))
	{
	 query.setString("pname", searchPersonPojo.getPersonName()+"%");
	}
	if(searchPersonPojo.getPassportNo()!=null && !searchPersonPojo.getPassportNo().trim().equals(""))
	{
	 query.setString("pptno", searchPersonPojo.getPassportNo()+"%");
	}
	if(searchPersonPojo.getPhoneNo()!=null && !searchPersonPojo.getPhoneNo().trim().equals(""))
	{
	 query.setString("phnum", searchPersonPojo.getPhoneNo()+"%");
	}
	if(searchPersonPojo.getCourses()!=null && !searchPersonPojo.getCourses().trim().equals(""))
	{
	 query.setString("cname", searchPersonPojo.getCourses());
	}
	List<Object[]> list=query.list();*/
		//Session session=HibernateUtil.getSession();
		Session session=sf.openSession();
		Criteria crt=session.createCriteria(PersonPojo.class,"person");
		crt.createAlias("person.passport", "passport");
		crt.createAlias("person.phone", "phone");
		crt.createAlias("person.course", "course");
		if(searchPersonPojo.getPersonName()!=null && !searchPersonPojo.getPersonName().trim().equals(""))
		{
			crt.add(Restrictions.like("person.name",searchPersonPojo.getPersonName()+"%"));
		}
		if(searchPersonPojo.getPassportNo()!=null && !searchPersonPojo.getPassportNo().trim().equals(""))
		{
			crt.add(Restrictions.like("passport.no",searchPersonPojo.getPassportNo()+"%"));
		}
		if(searchPersonPojo.getPhoneNo()!=null && !searchPersonPojo.getPhoneNo().trim().equals(""))
		{
			crt.add(Restrictions.like("phone.num",searchPersonPojo.getPhoneNo()+"%"));
		}
		if(searchPersonPojo.getCourses()!=null && !searchPersonPojo.getCourses().trim().equals(""))
		{
			crt.add(Restrictions.like("course.name",searchPersonPojo.getCourses()+"%"));
		}
		ProjectionList proList=Projections.projectionList();
		proList.add(Projections.groupProperty("person.name"));
		proList.add(Projections.groupProperty("passport.no"));
		proList.add(Projections.groupProperty("phone.num"));
		proList.add(Projections.count("course.name"));
		crt.setProjection(proList);
		List<Object[]> list= crt.list();
    return list;
}
}