package com.masai.services;

public interface CustomerService {
	
	void raiseIssue(String description);
	void raiseIssueState(String issueId);
	void provideFeedback(String issueId, String feedback);
	void viewIssueStatus(String issueId);
}