package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int customerId);

	public void delete(int id);

	public List<Customer> search(String name);

}
