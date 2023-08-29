package com.masai.services;

import java.util.List;

import com.masai.enm.Feedback;
import com.masai.entity.Customer;
import com.masai.entity.Issue;

public interface Customerser {
	
	void addNewCustomer(Customer cus);

	void createIssue(Issue issue);

	List<Issue> viewAllIssuesAndGiveFeed(int id);

	void giveFeedBackToIssues(int id, Feedback feed);

}
