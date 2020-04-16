package com.webapp.practice.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Min(value = 18)
	@Max(value = 100)
	@Column(name = "age")
	private int age;

	@NotBlank(message = "Email is mandatory")
	@Email
	@Column(name = "email")
	private String email;

	@OneToOne
	@JoinColumn(name = "country_id")
	public Country country;

	public Customer() {

	}

	public Customer(@NotNull @Size(min = 1, message = "is required") String firstName,
			@NotNull @Size(min = 1, message = "is required") String lastName, @NotNull @Min(18) @Max(100) int age,
			@NotBlank(message = "Email is mandatory") @Email String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", email=" + email + ", country=" + country + "]";
	}

}
