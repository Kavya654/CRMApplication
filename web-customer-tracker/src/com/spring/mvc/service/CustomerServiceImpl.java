package com.spring.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.CustomerDao;
import com.spring.mvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();

	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		
		return customerDao.getCustomer(customerId);
	
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}

	@Override
	@Transactional
	public List<Customer> search(String name) {
		
		return customerDao.search(name);
	}

}
