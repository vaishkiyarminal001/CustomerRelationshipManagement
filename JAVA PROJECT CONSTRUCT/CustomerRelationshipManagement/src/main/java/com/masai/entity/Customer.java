package com.masai.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	//inverse/referencing side

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Customer_User_Name" , nullable = false)
	private String userName;
	
	@Column(name = "Customer_User_Pass" , nullable = false)
	private String passWord;
	
	@Column(name = "Customer_Name")
	private String name;
	
	@Column(name = "Customer_eMail")
	private String eMail;
	
	@Column(name = "Customer_Address")
	private String address;
	
	@OneToMany(mappedBy = "customer"  , cascade = CascadeType.ALL)
	private Set<Issue> issues;

	@ManyToMany(mappedBy = "customer",fetch = FetchType.EAGER )
	private Set<CSR> csr;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String userName, String passWord, String name, String eMail, String address, Set<Issue> issues,
			Set<CSR> csr) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.eMail = eMail;
		this.address = address;
		this.issues = issues;
		this.csr = csr;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Issue> getIssues() {
		return issues;
	}


	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}


	public Set<CSR> getCsr() {
		return csr;
	}


	public void setCsr(Set<CSR> csr) {
		this.csr = csr;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", name=" + name
				+ ", eMail=" + eMail + ", address=" + address +  "]";
	}


	}
