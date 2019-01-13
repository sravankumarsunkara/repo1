package com.slokam.ebank.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration cfg;
	private static SessionFactory sf;
    static
    {
    	cfg=new AnnotationConfiguration().configure();
    	sf=cfg.buildSessionFactory();
    }
    public static Session getSession()
    {
    	return sf.openSession();
    }
}
