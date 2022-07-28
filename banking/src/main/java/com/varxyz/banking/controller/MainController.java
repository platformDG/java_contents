package com.varxyz.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.SavingsAccount;
import com.varxyz.banking.service.AccountService;
import com.varxyz.banking.service.CustomerService;


@Controller("banking.mainController")
public class MainController {
	
	@Autowired
	private CustomerService cs;
	@Autowired
	private AccountService as;
	
	//로그인페이지
	@GetMapping("/login")
	public String loginPage() {
		return "/login";
	}
	
	/**
	 * 강제로 주소창에 main이라고 적으면
	 * 세션확인후에 main페이지를 보여준다.
	 * 세션이 끊겨있다면 로그인페이지로 보여준다.
	 */
	@GetMapping("/main")
	public String mainPage(HttpServletRequest request, HttpServletResponse response,
			Model model) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if (userId == null || userId.length() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 사용 해주시기 바랍니다.'); location.href='/banking/login'; </script>"); // 경고창 띄우기
			writer.close();
			return "/login";
		}
		else {
			List<Account> list = as.findAccountByCustomerId(userId);
			model.addAttribute("list", list);
			return "/main";
		}
	}
	
	//로그인 후 메인페이지
	@PostMapping("/main")
	public ModelAndView loginConfirm(@RequestParam String userId, @RequestParam String passwd, 
			HttpServletRequest request) {
		int i = cs.findCustomerByUserIdPasswd(userId, passwd);
		ModelAndView mav = new ModelAndView();
		if(i < 1) {
			String errMsg = "아이디 혹은 비밀번호가 일치하지 않습니다.";
			mav.addObject("errMsg", errMsg);
			mav.setViewName("login");
		}
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", userId);
			List<Account> list = as.findAccountByCustomerId(userId);
			mav.addObject("list", list);
			mav.setViewName("main");
		}
		return mav;
	}

	//잔액조회
	@GetMapping("/checking_balance/checking_balance")
	public String checkingBanlanceFrom(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		List<Account> list = as.findAccountByCustomerId(userId);
		model.addAttribute("list",list);
		return "/checking_balance/checking_balance";
	}
	
	@PostMapping("/checking_balance/checking_balance")
	public ModelAndView checkingBanlanceConfirm(@RequestParam String accountNum) {
		Account a = as.findAccountByAccountNum(accountNum);
		ModelAndView mav = new ModelAndView();
		mav.addObject("account", a);
		mav.setViewName("/checking_balance/checking_balance_result");
		return mav;
	}
	
	@GetMapping("/save_interest/save_interest")
	public ModelAndView saveInterestFrom() {
		List<Account> list = as.findAllAccount();
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("account", list);
		for(Account a : list) {
			if(a instanceof SavingsAccount ) {
				SavingsAccount sa = (SavingsAccount) a;
				sa.saveInterrest();
				as.setBalance(sa.getAccountNum(), sa.getBalance());
			}
		}
		mav.setViewName("/save_interest/save_interest_result");
		return mav;
	}
}
