package com.webapp.practice.springrest.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int countryId;

	@Column(name = "countrycode")
	private String countryCode;

	@Column(name = "countryname")
	private String countryName;
	
	public Country() {

	}

	public Country(String countryCode, String countryName) {
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int id) {
		this.countryId = id;
	}

	@Override
	public String toString() {
		return "Country [customer_id=" + countryId + ", countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}

}
