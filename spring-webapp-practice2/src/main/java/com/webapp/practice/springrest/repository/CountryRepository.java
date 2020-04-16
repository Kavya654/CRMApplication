package com.webapp.practice.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.practice.springrest.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
