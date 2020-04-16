package com.webapp.practice.springrest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.practice.springrest.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c where   (c.firstName = :name or c.lastName = :name)  and c.age = :age")
	List<Customer> searchByNameAge(@RequestParam("name") Optional<String> name,
			@RequestParam("age") Optional<Integer> age);

	@Query("SELECT c FROM Customer c where c.firstName = :name or c.lastName = :name ")
	List<Customer> searchByName(@RequestParam("name") Optional<String> name);

	@Query("SELECT c FROM Customer c where c.age = :age")
	List<Customer> searchByAge(@RequestParam("age") Optional<Integer> age);

}
