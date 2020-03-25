package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.entity.Customer;
import com.spring.mvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerServ;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> customers = customerServ.getCustomers();

		theModel.addAttribute("customers", customers);
		return "customer-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);

		System.out.println("from form " + customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		System.out.println("saving ..." + theCustomer);

		customerServ.saveCustomer(theCustomer);

		System.out.println("saved");

		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model theModel) {

		Customer customer = customerServ.getCustomer(customerId);

		theModel.addAttribute("customer", customer);

		return "customer-form";

	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("id") int id) {
		customerServ.delete(id);
		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String search(@RequestParam("searchByName") String name, Model theModel) {

		List<Customer> customers = customerServ.search(name);

		theModel.addAttribute("customers", customers);

		return "customer-list";

	}
}
