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
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.command.CustomerCommand;
import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
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
	//메인페이지
	@GetMapping("/index")
	public String mainPage() {
		return "/index";
	}
	
	//로그인 후 메인페이지
	@PostMapping("/index")
	public ModelAndView loginConfirm(@RequestParam String userId, @RequestParam String passwd, HttpServletRequest request) {
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
			mav.setViewName("index");
		}
		return mav;
	}

	//회원가입 페이지
	@GetMapping("/add_customer/add_customer")
	public String addCustomerForm() {
		return "/add_customer/add_customer";
	}
	
	//회원가입 처리 페이지
	@PostMapping("/add_customer/add_customer")
	public String addCustomerConfirm(CustomerCommand customerCommand) {
		Customer c = new Customer();
		c.setUserId(customerCommand.getUserId());
		c.setPasswd(customerCommand.getPasswd());
		c.setName(customerCommand.getName());
		c.setSsn(customerCommand.getSsn());
		c.setPhone(customerCommand.getPhone());

		cs.addCustomer(c);

		return "/add_customer/add_customer_result";
	}
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
	//송금 조회 페이지
	@GetMapping("/transfer_balance/transfer_balance")
	public String transferBanlanceFrom(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		List<Account> list = as.findAccountByCustomerId(userId);
		model.addAttribute("userId",userId);
		model.addAttribute("list",list);
		
		return "/transfer_balance/transfer_balance";
	}
	
	@PostMapping("/transfer_balance/transfer_balance")
	public ModelAndView transferBanlanceConfirm(@RequestParam double balance,
			@RequestParam String outputAccountNum, @RequestParam String inputAccountNum, 
			@RequestParam String passwd, @RequestParam String userId) {
		ModelAndView mav = new ModelAndView();
		int i = cs.findCustomerByUserIdPasswd(userId, passwd);
		if(i < 1) {
			String errMsg = "비밀번호가 틀립니다.";
			mav.addObject("errMsg", errMsg);
			mav.setViewName("transfer_balance/transfer_balance");
			return mav;
		}

		Account outAccount = as.findAccountByAccountNum(outputAccountNum);
		Account inAccount = as.findAccountByAccountNum(inputAccountNum);
		
		if(outAccount.getAccountNum().equals(inAccount.getAccountNum())) {
			String errMsg = "동일한 계좌에 송금할 수 없습니다.";
			mav.addObject("errMsg", errMsg);
			mav.setViewName("transfer_balance/transfer_balance");
			return mav;
		}
		if (outAccount instanceof SavingsAccount) {
			SavingsAccount osa = (SavingsAccount) outAccount;
			if(osa.withdraw(balance)) {
				as.setBalance(osa.getAccountNum(), osa.getBalance());
				
				if(inAccount instanceof SavingsAccount) {
					SavingsAccount isa = (SavingsAccount) inAccount;
					isa.deposite(balance);
					as.setBalance(isa.getAccountNum(), isa.getBalance());
				}else {
					CheckingAccount ica = (CheckingAccount) inAccount;
					System.out.println(ica.getBalance());
					ica.deposite(balance);
					System.out.println(ica.getBalance());
					as.setBalance(ica.getAccountNum(), ica.getBalance());
				}
				mav.addObject("outAccount", outAccount);
				mav.addObject("inAccount", inAccount);
				mav.addObject("balance", balance);
				mav.setViewName("transfer_balance/transfer_balance_result");
			}
			else {
				String errMsg = "잔액이 부족합니다.";
				mav.addObject("errMsg", errMsg);
				mav.setViewName("transfer_balance/transfer_balance");
			}
		}
		else {
			CheckingAccount oca = (CheckingAccount) outAccount;
			if(oca.withdraw(balance)) {
				as.setBalance(oca.getAccountNum(), oca.getBalance());
				if(inAccount instanceof SavingsAccount) {
					SavingsAccount isa = (SavingsAccount) inAccount;
					isa.deposite(balance);
					as.setBalance(isa.getAccountNum(), isa.getBalance());
				}else {
					CheckingAccount ica = (CheckingAccount) inAccount;
					ica.deposite(balance);
					as.setBalance(ica.getAccountNum(), ica.getBalance());
				}
				mav.addObject("outAccount", outAccount);
				mav.addObject("inAccount", inAccount);
				mav.addObject("balance", balance);
				mav.setViewName("transfer_balance/transfer_balance_result");
			}
			else {
				String errMsg = "잔액이 부족합니다.";
				mav.addObject("errMsg", errMsg);
				mav.setViewName("transfer_balance/transfer_balance");
			}
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
