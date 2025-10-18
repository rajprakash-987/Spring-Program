package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankAccountManagementService {
	public String openAccount(BankAccount account);
	public String withdrawAmount(long acno,double amt);
	public BankAccount showAccountByAcno(long acno);

}
