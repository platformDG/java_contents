package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService as;
	//계좌가입 페이지
		@GetMapping("/add_account/add_account")
		public String addAccountForm(HttpServletRequest request, Model model) {
			HttpSession session = request.getSession(false);
			String userId = (String) session.getAttribute("userId");
			model.addAttribute("userId",userId);
			
			return "/add_account/add_account";
		}
		
		//계좌가입 처리
		@PostMapping("/add_account/add_account")
		public String addAccountConfirm(@RequestParam String userId, @RequestParam char accType, 
				@RequestParam double darftOrRate, @RequestParam double balance) {
			as.addAccount(userId, accType, darftOrRate, balance);
			return "/add_account/add_account_result";
		}
		
		//계좌목록 조회 페이지
		@GetMapping("/search_account/search_account")
		public String searchAccountFrom(HttpServletRequest request, Model model) {
			HttpSession session = request.getSession(false);
			String userId = (String) session.getAttribute("userId");
			model.addAttribute("userId",userId);
			return "/search_account/search_account";
		}
		
		//계좌목록 처리 페이지	
		@PostMapping("/search_account/search_account")
		public String searchAccountConfirm(@RequestParam String userId, Model model) {
			List<Account> list = as.findAccountByCustomerId(userId);
			model.addAttribute("list", list);
			return "/search_account/search_account_result";
		}
}
