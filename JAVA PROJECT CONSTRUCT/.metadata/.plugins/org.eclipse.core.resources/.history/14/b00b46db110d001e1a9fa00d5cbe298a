//package com.masai.dao;
//
//import java.util.Optional;
//import com.masai.entity.*;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.TypedQuery;
//
//public class GetCSRCredsDaoImpl implements GetCSRCredsDao{
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public CSR getCSRByUsername(String username) {
//		
//		String queryString = "SELECT c FROM CSR c WHERE c.username = :username";
//		TypedQuery<CSR> query = entityManager.createQuery(queryString, CSR.class);
//        
//        query.setParameter("username", username);
//        return query.getSingleResult();
//		
//	}
//
//	@Override
//	public Optional<AdminCreds> getCSRCredentials() {
//		
//		 String adminUsername = "admin";
//		 String adminPassword = "admin123";
//		 
//		 if (isValidAdminCredentials(adminUsername, adminPassword)) {
//		        
//		      AdminCreds adminCreds = new AdminCreds(adminUsername, adminPassword);
//		      
//		 
//		        return Optional.of(adminCreds);
//		    } else {
//		        
//		        return Optional.empty();
//		    }
//		}
//
//
//		private boolean isValidAdminCredentials(String username, String password) {
//		   
//	 return username.equals("admin") && password.equals("admin123");
//		}
//	}
//
//
