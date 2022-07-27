package com.varxyz.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.SavingsAccount;


public class CustomerAccountRowMapper implements RowMapper<Account>{
	
	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account a = null;
		char accType = rs.getString("accType").charAt(0);
		if(accType == 'C') {
			a  = new CheckingAccount();
			CheckingAccount ca = (CheckingAccount) a;
			ca.setOverdraftAmount(rs.getDouble("overAmount"));
		}else {
			a  = new SavingsAccount();
			SavingsAccount sa = (SavingsAccount) a;
			sa.setInterestRate(rs.getDouble("interestRate"));
		}
		a.setAid(rs.getLong("aid"));
//		a.setCustomer(new Customer(rs.getLong("customerId")));
		a.setAccountNum(rs.getString("accountNum"));
		a.setBalance(rs.getDouble("balance"));
		a.setRegDate(rs.getTimestamp("regDate"));
		
		return a;
	}
}
