package com.webapp.practice.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.practice.springrest.entity.Country;
import com.webapp.practice.springrest.entity.Customer;
import com.webapp.practice.springrest.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public String landing(Model model, @RequestParam("name") Optional<String> name,
			@RequestParam("age") Optional<Integer> age) {

		List<Customer> customer = new ArrayList<Customer>();

		if ((name.isPresent() && !name.get().isEmpty()) && age.isPresent()) {
			customer = service.searchByNameAge(name, age);
		} else if (name.isPresent() && !name.get().isEmpty()) {
			customer = service.searchByName(name);
		} else if (age.isPresent()) {
			customer = service.searchByAge(age);
		} else {
			customer = service.findAll();
		}

		model.addAttribute("name", name.isPresent() ? name.get() : "");
		model.addAttribute("age", age.isPresent() ? age.get() : "");
		model.addAttribute("customer", customer);

		return "landing";
	}

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "login";

	}

	@GetMapping("/register")
	public String register(Model model) {

		List<Country> countryList = new ArrayList<>();

		countryList = service.findAllCountry();

		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("country", countryList);
		model.addAttribute("isUpdateMode", false);

		System.out.println(countryList);

		return "register";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			@RequestParam("id") int id) {

		if (bindingResult.hasErrors()) {
			return "register";
		} else {
			customer.setId(id);

			service.save(customer);

			return "redirect:/";
		}
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, Model model) {
		Customer customer = service.findById(id);

		List<Country> countryList = new ArrayList<>();

		countryList = service.findAllCountry();

		model.addAttribute("customer", customer);
		model.addAttribute("country", countryList);
		model.addAttribute("isUpdateMode", true);

		return "register";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		service.deleteById(id);
		return "redirect:/";

	}

}
