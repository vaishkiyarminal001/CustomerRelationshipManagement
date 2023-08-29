package com.masai.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_Support_Representatives")
public class CSR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CSR_User_Name" , nullable = false)
	private String userName;
	
	@Column(name = "CSR_User_Pass" , nullable = false)
	private String passWord;
	
	@Column(name = "CSR_Name")
	private String name;
	
	@Column(name = "CSR_eMail")
	private String eMail;
	

	@Column(name = "CSR_Address")
	private String address;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="Csr_Customer" , 
		       joinColumns = {@JoinColumn(referencedColumnName = "id")},
		       inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")}
			)
	private Set<Customer> customer;
	
	public CSR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CSR(String userName, String passWord, String name, String eMail, String address, Set<Customer> customer) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.eMail = eMail;
		this.address = address;
		this.customer = customer;
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

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Csr [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", name=" + name + ", eMail="
				+ eMail + ", address=" + address + "]";
	}



}
