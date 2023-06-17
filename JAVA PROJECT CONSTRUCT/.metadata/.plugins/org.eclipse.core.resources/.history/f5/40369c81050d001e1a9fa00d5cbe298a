package com.masai.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

import com.masai.entity.Customer;

public class GetCustomerCredsDaoImpl implements GetCustomerCredsDao {

    private EntityManagerFactory entityManagerFactory;

    public GetCustomerCredsDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("CRM");
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            String queryString = "SELECT c FROM Customer c WHERE c.username = :username";
            TypedQuery<Customer> query = entityManager.createQuery(queryString, Customer.class);
            query.setParameter("username", username);
            return query.getSingleResult();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean checkCustomerCredentials(String username, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            String queryString = "SELECT COUNT(c) FROM Customer c WHERE c.username = :username AND c.password = :password";
            TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            Long count = query.getSingleResult();
            return count > 0;
        } finally {
            entityManager.close();
        }
    }

    public void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

	@Override
	public Optional<Customer> getCustomerCredentials() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

	    try {
	        String queryString = "SELECT c FROM Customer c";
	        TypedQuery<Customer> query = entityManager.createQuery(queryString, Customer.class);
	        List<Customer> customers = query.getResultList();
	        
	        if (!customers.isEmpty()) {
	            
	            Customer customer = customers.get(0);
	            return Optional.of(customer);
	        }
	    } finally {
	        entityManager.close();
	    }

	    return Optional.empty();
	}
}
