package com.masai.dao;

import com.masai.enm.Feedback;
import com.masai.enm.IssueStatus;
import com.masai.entity.*;
import jakarta.persistence.*;
import java.util.*;

import org.hibernate.internal.build.AllowSysOut;

public class CustomerDaoImpl implements CustomerDao{
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");

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
		EntityManager em = null;
		EntityTransaction et = null;
		
        try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(issue);
			et.commit();
			
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			em.close();	
		}
		
	}

	@Override
	public List<Issue> viewAllIssuesAndGiveFeed(int id) {
List<Issue> issueList = null;
		
		try{
			
			EntityManager em = emf.createEntityManager();
			
            String getIssues = "SELECT c FROM Issue c WHERE c.customer.id=:id";
			
			Query createQuery = em.createQuery(getIssues);
			
			createQuery.setParameter("id", id);
			
			 issueList = (List<Issue>) createQuery.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return issueList;

	}

	@Override
	public void giveFeedBackToIssues(int id, Feedback feed) {
		EntityManager em = null;
		EntityTransaction et = null;
		int executeUpdate = 0 ;
         try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			String que = "UPDATE Issue i SET feedback=:feed WHERE id=:id AND status=:stat";

			Query query = em.createQuery(que);
				
			query.setParameter("feed", feed);
			query.setParameter("id", id);
			query.setParameter("stat", IssueStatus.CLOSED);
			
			et.begin();
			executeUpdate = query.executeUpdate();
			et.commit();
			
		} catch (Exception e) {
			
			et.rollback();
			
			System.out.println(e.getMessage());
			
		}finally {
			
			em.close();
			
		}
		
         if(executeUpdate > 0 ) {
        	 System.out.println("Feedback Successfully imparted");
         }else {
        	 System.out.println("Feedback Couldn't imparted");
         }
         
		
	}

	@Override
	public void addNewCustomer(Customer cus) {
		// TODO Auto-generated method stub
		
	}

		
	
	}
