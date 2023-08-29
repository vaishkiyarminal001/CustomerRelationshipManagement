package com.masai.dao;

import java.util.List;

import com.masai.enm.Feedback;
import com.masai.entity.*;

public interface CustomerDao {
	
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
	Customer getCustomerById(String customerId);
	void createIssue(Issue issue);
	List<Issue> viewAllIssuesAndGiveFeed(int id);
	void giveFeedBackToIssues(int id, Feedback feed);
	void addNewCustomer(Customer cus);

}
