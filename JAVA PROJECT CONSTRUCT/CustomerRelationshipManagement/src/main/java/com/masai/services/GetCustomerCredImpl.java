package com.masai.services;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.utility.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class GetCustomerCredImpl implements GetCustomerCred {
    static EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
    
    

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerCredentials(String username, String password) {

		Customer csr = null;
    try{
    	EntityManager em = emf.createEntityManager();
            String getCredsQue = "SELECT c FROM Customer c WHERE c.userName=:userName AND c.passWord=:passWord";
			
			Query createQuery = em.createQuery(getCredsQue);
			createQuery.setParameter("userName", username);
			createQuery.setParameter("passWord", password);
			 csr =  (Customer) createQuery.getSingleResult();
//			System.out.println(csr);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return csr;
	

	}


	
   
}
