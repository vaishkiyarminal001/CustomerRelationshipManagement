package com.masai.dao;

import java.util.List;

import com.masai.enm.Feedback;
import com.masai.enm.IssueStatus;
import com.masai.entity.CSR;
import com.masai.entity.Issue;



public interface CSRDao {

	 public void addNewCSR(CSR csr);
	 public List<Issue> viewAllIssues();
	 public void manageIssue(int id , IssueStatus rev , Feedback feed );
	 public void viewFeedBackByCustomers();
}
