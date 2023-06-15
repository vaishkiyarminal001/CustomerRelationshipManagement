package com.masai.services;

public class CSRServicesImpl implements CSRServices{
	
	@Override
	public void viewAndManageIssue() {
		
		System.out.println("Viewing and managing issues");
		
	}
	
	
	@Override
	public void replayToIssue(String issueId, String reply) {
		
		System.out.println("Replying the issues with ID: " + issueId);
		System.out.println("Reply" + reply);
		
	}
	
	@Override
	public void closeIssue(String issueId) {
		
		System.out.println("Closing issues with ID" + issueId);
		
	}
			
	@Override
	public void viewFeedback() {
		
		System.out.println("View Feedback");
		
	}

}
