package com.masai.services;



import java.util.List;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.enm.Feedback;
import com.masai.entity.Customer;
import com.masai.entity.Issue;



public abstract class CustomerServicesImpl implements Customerser {

	@Override
	public void addNewCustomer(Customer cus) {
		
		CustomerDao cusDao = new CustomerDaoImpl();
		
		cusDao.addNewCustomer(cus);
		
	}

	@Override
	public void createIssue(Issue issue) {
		

		CustomerDao cusDao = new CustomerDaoImpl();
		
		cusDao.createIssue(issue);
	}

	@Override
	public List<Issue> viewAllIssuesAndGiveFeed(int id) {
	
		CustomerDao cusDao = new CustomerDaoImpl();
		List<Issue> issueList = cusDao.viewAllIssuesAndGiveFeed(id);
		return issueList;
	}

	@Override
	public void giveFeedBackToIssues(int id, Feedback feed) {
		
		CustomerDao cusDao = new CustomerDaoImpl();
		cusDao.giveFeedBackToIssues(id, feed);
	}
    
    
}
