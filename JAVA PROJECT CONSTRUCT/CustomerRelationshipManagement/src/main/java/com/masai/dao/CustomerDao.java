package com.masai.dao;

import com.masai.entity.*;

public interface CustomerDao {
	
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
	Customer getCustomerById(String customerId);

}
