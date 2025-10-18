package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;

@Service
public class BankAccountMgmtServiceImpl implements IBankAccountManagementService {
	@Autowired
	private IBankAccountRepository accountRepo;

	@Override
	public String openAccount(BankAccount account) {
		long idVal=accountRepo.save(account).getAcno();
		return"bank Account is oppened with the account number:"+idVal;
		
	}
	
	@Override
	public String withdrawAmount(long acno, double amt) {
		BankAccount account=accountRepo.findById(acno).orElseThrow(()->new IllegalArgumentException("account not found"));
		if(account!=null) {
			//withdraw amount
			account.setBalance(account.getBalance()-amt);
			accountRepo.save(account);
			return "Money is withdrawn";
		}
		return "Account not found";
	}
	
	@Override
	public BankAccount showAccountByAcno(long acno) {
		
		return accountRepo.findById(acno).orElseThrow(()->new IllegalArgumentException("invalid acno"));
	}

}
