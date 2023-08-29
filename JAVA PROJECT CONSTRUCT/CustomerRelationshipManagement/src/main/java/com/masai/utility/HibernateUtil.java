package com.masai.utility;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class HibernateUtil {
	
	public static EntityManagerFactory getEntityManagerFactory() {

		return Persistence.createEntityManagerFactory("CRM");
		
		
	}

}
