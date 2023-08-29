package com.masai.entity;

import java.time.LocalDate;

import com.masai.enm.Category;
import com.masai.enm.Feedback;
import com.masai.enm.IssueStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private LocalDate createdAt;
	
	@Enumerated(EnumType.STRING)
	private IssueStatus status;
	
	@Enumerated(EnumType.STRING)
	private Feedback feedback;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	public Issue() {
		super();
	}


	public Issue(Category category, LocalDate createdAt, IssueStatus status, Feedback feedback, Customer customer) {
		super();
		this.category = category;
		this.createdAt = createdAt;
		this.status = status;
		this.feedback = feedback;
		this.customer = customer;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public LocalDate getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	public IssueStatus getStatus() {
		return status;
	}


	public void setStatus(IssueStatus status) {
		this.status = status;
	}


	public Feedback getFeedback() {
		return feedback;
	}


	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Issue [id=" + id + ", category=" + category + ", createdAt=" + createdAt + ", status=" + status
				+ ", feedback=" + feedback + ", customer=" + customer.getName() + "]";
	}
	
	

}
