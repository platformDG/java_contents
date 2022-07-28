package com.varxyz.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.command.CustomerCommand;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.service.CustomerService;

@Controller
public class CustomerSignController {
	@Autowired
	private CustomerService cs;
	
	//회원가입 페이지
	@GetMapping("/add_customer/add_customer")
	public String addCustomerForm() {
		return "/add_customer/add_customer";
	}
	
	//회원가입 처리 페이지
	@PostMapping("/add_customer/add_customer")
	public String addCustomerConfirm(CustomerCommand customerCommand, Model model) {
		Customer c = new Customer();
		c.setUserId(customerCommand.getUserId());
		c.setPasswd(customerCommand.getPasswd());
		c.setName(customerCommand.getName());
		c.setSsn(customerCommand.getSsn());
		c.setPhone(customerCommand.getPhone());
		
		cs.addCustomer(c);
		model.addAttribute("customer", c);
		return "/add_customer/add_customer_result";
	}
}
