package com.masai.services;

import java.util.List;

import com.masai.entity.Customer;

public interface GetCustomerCred {

	public  Customer getCustomerCredentials(String username , String password);

	List<Customer> getCustomerList();
}
