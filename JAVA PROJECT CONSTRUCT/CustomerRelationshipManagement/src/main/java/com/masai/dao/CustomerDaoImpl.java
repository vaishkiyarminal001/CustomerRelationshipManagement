package com.masai.dao;

import com.masai.enm.Feedback;
import com.masai.entity.*;
import jakarta.persistence.*;
import java.util.*;

import org.hibernate.internal.build.AllowSysOut;

public class CustomerDaoImpl implements CustomerDao{
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
	public CustomerDaoImpl(EntityManager entityManager) {
	}

	@Override
	public void saveCustomer(Customer customer) {
	
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try{
		et.begin();
		em.persist(customer);
		et.commit();
		System.out.println("Hurry!!!!Customer Saved Successfully");
		
	}catch(Exception e) {
		if(et != null && et.isActive()) {
			et.rollback();
		}
		
		System.out.println("Oh No...Error Saving Customer: " + e.getMessage());
		
	}finally {
		em.close();
	}
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try{
			et.begin();
			em.merge(customer);
			et.commit();
			System.out.println("Hurry!!!!Customer Updated Successfully");
			
		}catch(Exception e) {
			if(et != null && et.isActive()) {
				et.rollback();
			}
			
			System.out.println("Error Updating Customer: " + e.getMessage());
			
		}finally {
			em.close();
		}
		}
	
	@Override
	public void deleteCustomer(String customerId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try{
			et.begin();
			Customer customer = em.find(Customer.class, customerId);
			
			if(customer != null) {
			em.remove(customer);	
			et.commit();
			System.out.println("So Sad...Customer Deleted Successfully!!");
			
			}else {
				System.out.println("No Customer Found with the provided ID: " + customerId);
			
			}
			
		}catch(Exception e) {
			if(et != null && et.isActive()) {
				et.rollback();
			}
			
			System.out.println("Oh No...Error Deleting Customer: " + e.getMessage());
			
		}finally {
			em.close();
		}
		
	}
	
	@Override
	public Customer getCustomerById(String customerId) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Customer.class, customerId);
		}catch(Exception e) {
			System.out.println("Error Error Error in retriving Customer: " + e.getMessage());
		}finally {
			em.close();
		}
		return null;
	}

	@Override
	public void createIssue(Issue issue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Issue> viewAllIssuesAndGiveFeed(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void giveFeedBackToIssues(int id, Feedback feed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewCustomer(Customer cus) {
		// TODO Auto-generated method stub
		
	}

		
	
	}
