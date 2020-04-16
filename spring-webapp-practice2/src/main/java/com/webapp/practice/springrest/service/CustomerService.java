package com.webapp.practice.springrest.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.practice.springrest.entity.Country;
import com.webapp.practice.springrest.entity.Customer;
import com.webapp.practice.springrest.repository.CountryRepository;
import com.webapp.practice.springrest.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private CountryRepository countryRepo;

	public List<Customer> searchByName(Optional<String> name) {
		return repo.searchByName(name);
	}

	public List<Customer> searchByAge(Optional<Integer> age) {

		return repo.searchByAge(age);
	}

	public List<Customer> searchByNameAge(Optional<String> name, Optional<Integer> age) {

		return repo.searchByNameAge(name, age);
	}

	public void save(@Valid Customer customer) {
		repo.save(customer);
	}

	public Customer findById(int id) {

		return repo.findById(id).get();
	}

	public void deleteById(int id) {
		repo.deleteById(id);

	}

	public List<Country> findAllCountry() {

		return countryRepo.findAll();
	}

	public List<Customer> findAll() {

		return repo.findAll();
	}

}
