package com.masai.entity;

import com.masai.enm.IssueStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "Issue")

public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "customerId", nullable = false)
	private int customerId;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private IssueStatus status;
	
	@Column(name = "feedback")
	private String feedback;
	
	public Issue() {
		
	}

	public Issue(int customerId, String description, IssueStatus status, String feedback) {
		
		this.customerId = customerId;
		this.description = description;
		this.status = status;
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
