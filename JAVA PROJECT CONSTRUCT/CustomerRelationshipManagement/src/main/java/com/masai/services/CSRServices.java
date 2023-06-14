package com.masai.services;

public interface CSRServices {
	
	void viewAndManageIssue();
	void replayToIssue(String issueId, String reply);
	void closeIssue(String issueId);
	void viewFeedback();

}
