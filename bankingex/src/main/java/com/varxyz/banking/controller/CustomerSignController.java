package com.varxyz.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.command.CustomerCommand;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class CustomerSignController {
	@Autowired
	private CustomerServiceImpl cs;
	
	//회원가입 페이지
	@GetMapping("/add_customer/add_customer")
	public String addCustomerForm() {
		return "/add_customer/add_customer";
	}
	
	//회원가입 처리 페이지
	@PostMapping("/add_customer/add_customer")
	public String addCustomerConfirm(CustomerCommand customerCommand, Model model) {
		cs.addCustomer(customerCommand.getUserId(), customerCommand.getPasswd(), 
				customerCommand.getName(), customerCommand.getSsn(), customerCommand.getPhone());
		model.addAttribute("customer", customerCommand);
		return "/add_customer/add_customer_result";
	}
}
