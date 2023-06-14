package com.masai.utility;

import org.hibernate.cfg.Configuration;

import org.hibernate.*;

public class HibernateUtil {

	public static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		}catch(Throwable ex) {
			System.out.println("Failed to create sessionFactory object: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
