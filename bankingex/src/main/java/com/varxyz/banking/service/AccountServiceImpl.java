package com.varxyz.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.command.TransferCommand;
import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.SavingsAccount;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao dao;
	
	@Autowired
	private CustomerDao cDao;
	
	@Override
	public Account addAccount(String userId, char accType, double darftOrRate, double balance) {
		Account a = null;

		if (accType == 'S') {
			a = new SavingsAccount();
			SavingsAccount sa = (SavingsAccount) a;
			sa.setInterestRate(darftOrRate);
		}
		else {
			a = new CheckingAccount();
			CheckingAccount ca = (CheckingAccount) a;
			ca.setOverdraftAmount(darftOrRate);
		}
		a.setBalance(balance);
		a.setCustomer(cDao.findCustomerByUserId(userId));
		a.setAccountNum(generateAccountNum());
		a.setAccType(accType);
		return dao.addAccount(a);	
		
	}
	public List<Account>  findAllAccount() {
		return dao.findAllAccount();
	}
	public List<Account> getAccounts(String userId) {
		return dao.findAccountByCustomerId(cDao.findCustomerByUserId(userId).getCid());
	}
	
	public Account findAccountByAccountNum(String accountNum) {
		return dao.findAccountByAccountNum(accountNum);
	}
	
	@Transactional
	public void setBalance(String accountNum, double balance) {
		dao.setBalance(accountNum, balance);
	}
	
	@Override
	@Transactional
	public String transfer(double amount, String outputAccount, String inputAccount) {
		double balance = amount; //transferCommand.getBalance();
		Account outAccount = findAccountByAccountNum(outputAccount);
		Account inAccount = findAccountByAccountNum(inputAccount);

		if(outAccount.getAccountNum().equals(inAccount.getAccountNum())) {
			return "동일한 계좌에 송금할 수 없습니다.";
		}
		
		if (outAccount instanceof SavingsAccount) {
			SavingsAccount osa = (SavingsAccount) outAccount;
			if(osa.withdraw(balance)) {
				setBalance(osa.getAccountNum(), osa.getBalance());
				
				if(inAccount instanceof SavingsAccount) {
					SavingsAccount isa = (SavingsAccount) inAccount;
					isa.deposite(balance);
					setBalance(isa.getAccountNum(), isa.getBalance());
				}else {
					CheckingAccount ica = (CheckingAccount) inAccount;
					ica.deposite(balance);
					setBalance(ica.getAccountNum(), ica.getBalance());
				}
				return "성공";
			}
			else {
				return "잔액이 부족합니다.";
			}
		}
		else {
			CheckingAccount oca = (CheckingAccount) outAccount;
			if(oca.withdraw(balance)) {
				setBalance(oca.getAccountNum(), oca.getBalance());
				if(inAccount instanceof SavingsAccount) {
					SavingsAccount isa = (SavingsAccount) inAccount;
					isa.deposite(balance);
					setBalance(isa.getAccountNum(), isa.getBalance());
				}else {
					CheckingAccount ica = (CheckingAccount) inAccount;
					ica.deposite(balance);
					setBalance(ica.getAccountNum(), ica.getBalance());
				}
				return "성공";
			}
			else {
				return "잔액이 부족합니다.";
			}
			
		}
	}
	@Override
	public double getBalance(String accountNum) {
		return dao.findAccountByAccountNum(accountNum).getBalance();
	}
	
	@Override
	public boolean saveInterest(double interestRate, String accountNum) {
		return true;
	}
	
	public String generateAccountNum() {
		String numStr = String.valueOf((int)(Math.random()*1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0,3));
		sb.append('-');
		sb.append(numStr.substring(3,5));
		sb.append('-');
		sb.append(numStr.substring(5,9));
		return sb.toString();
	}
}
