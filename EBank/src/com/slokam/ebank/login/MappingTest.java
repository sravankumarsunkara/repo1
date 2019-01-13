package com.slokam.ebank.login;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.ejb.support.AbstractEnterpriseBean;
import org.springframework.ejb.support.AbstractSessionBean;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.slokam.ebank.pojo.CoursePojo;
import com.slokam.ebank.pojo.PassportPojo;
import com.slokam.ebank.pojo.PersonPojo;
import com.slokam.ebank.pojo.PhonePojo;
import com.slokam.ebank.util.HibernateUtil;

public class MappingTest {
	public static void main1(String[] args) {
		Session session=HibernateUtil.getSession();
		PersonPojo person=(PersonPojo)session.get(PersonPojo.class, 1);
		System.out.println("Name "+person.getName());
		PassportPojo ppt=person.getPassport();
		System.out.println("passportNo is "+ppt.getNo());
		Collection<PhonePojo> phone=person.getPhone();
		System.out.println("Phone numbers are");
		for(PhonePojo list:phone)
		{
			System.out.print(list.getNum()+" ");
		}
		Collection<CoursePojo> course=person.getCourse();
		System.out.println("Joined Courses are ");
		for(CoursePojo list:course)
		{
			System.out.println(list.getName()+" ");
		}
	}
	public static void main2(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from PersonPojo");
		Collection<PersonPojo> list=query.list();
		for(PersonPojo person: list)
		{
			System.out.print(person.getName()+" ");
			System.out.println(person.getGender());
		}
	}
	public static void main3(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("select name from PersonPojo");
		Collection<Object> list=query.list();
		for(Object person: list)
		{
			System.out.println(person+" ");
			//System.out.println(person.getGender());
		}
	}
	public static void main4(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("select name,gender from PersonPojo");
		Collection<Object[]> list=query.list();
		for(Object[] person: list)
		{
			System.out.print(person[0]+" ");
			System.out.println(person[1]+" ");
			//System.out.println(person.getGender());
		}
	}
	public static void main5(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("select name,gender,qual from PersonPojo");
		Collection<Object[]> list=query.list();
		for(Object[] person: list)
		{
			System.out.print(person[0]+" ");
			System.out.print(person[1]+" ");
			System.out.println(person[2]+" ");
			//System.out.println(person.getGender());
		}
	}
	public static void main6(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("select p.name, ppt.no from PersonPojo p join p.passport ppt where p.id=1");
		Collection<Object[]> list=query.list();
		for(Object[] person: list)
		{
			System.out.print(person[0]+" ");
			System.out.println(person[1]+" ");
			//System.out.println(person[2]+" ");
			//System.out.println(person.getGender());
		}
	}
	public static void main7(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("select p.name, ppt.no,ppt.expDate from PersonPojo p join p.passport ppt where p.id=1");
		Collection<Object[]> list=query.list();
		for(Object[] person: list)
		{
			System.out.print(person[0]+" ");
			System.out.print(person[1]+" ");
			System.out.println(person[2]+" ");
			//System.out.println(person.getGender());
		}
	}
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("select p.name, ppt.no, ph.num from PersonPojo p join p.passport ppt join p.phone ph where p.id=1");
		Collection<Object[]> list=query.list();
		for(Object[] person: list)
		{
			System.out.print(person[0]+" ");
			System.out.print(person[1]+" ");
			System.out.println(person[2]+" ");
			//System.out.println(person.getGender());
		}
	}

}
