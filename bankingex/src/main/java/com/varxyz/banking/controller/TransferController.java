package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.command.TransferCommand;
import com.varxyz.banking.domain.Account;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class TransferController {
	@Autowired
	private CustomerServiceImpl cs;
	@Autowired
	private AccountServiceImpl as;
	
	//송금 조회 페이지
	@GetMapping("/transfer_balance/transfer_balance")
	public String transferBanlanceFrom(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		List<Account> list = as.getAccounts(userId);
		model.addAttribute("userId",userId);
		model.addAttribute("list",list);
		
		return "/transfer_balance/transfer_balance";
	}
		
	@PostMapping("/transfer_balance/transfer_balance")
	public ModelAndView transferBanlanceConfirm(TransferCommand transferCommand) {
		ModelAndView mav = new ModelAndView();
		String str = as.transfer(transferCommand.getBalance(), transferCommand.getOutputAccountNum(),
				transferCommand.getInputAccountNum());
		List<Account> list = as.getAccounts(transferCommand.getUserId());
		int i = cs.findCustomerByUserIdPasswd(transferCommand.getUserId(), transferCommand.getPasswd());
		if(i < 1) {
			String errMsg = "비밀번호가 틀립니다.";
			mav.addObject("errMsg", errMsg);
			mav.addObject("userId",transferCommand.getUserId());
			mav.addObject("list",list);
			mav.setViewName("transfer_balance/transfer_balance");
			return mav;
		}
		
		if(str.equals("성공")) {
			mav.addObject("outAccount", as.findAccountByAccountNum(transferCommand.getOutputAccountNum()));
			mav.addObject("inAccount", as.findAccountByAccountNum(transferCommand.getInputAccountNum()));
			mav.addObject("balance", transferCommand.getBalance());
			mav.setViewName("transfer_balance/transfer_balance_result");
		}else {
			mav.addObject("errMsg", str);
			mav.addObject("userId",transferCommand.getUserId());
			mav.addObject("list",list);
			mav.setViewName("transfer_balance/transfer_balance");
			return mav;
		}
		return mav;
	}
}
