package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.BankAccountMgmtServiceImpl;
import com.nt.service.IBankAccountManagementService;

@Component
public class VersionAndTimeStampTestRunner implements CommandLineRunner {
	@Autowired
	private IBankAccountManagementService bankService;
	@Override
	public void run(String... args) throws Exception {
		BankAccount account=new BankAccount();
		account.setHolderName("pavan");account.setBalance(60000.0);
		
		/*try {
			String msg=bankService.openAccount(account);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			String msg=bankService.withdrawAmount(30000, 1000.0);
			System.out.println(msg);
			BankAccount acc=bankService.showAccountByAcno(30000);
			System.out.println("accont is modifird for"+acc.getModificationCount()+"...opened on"+acc.getOpeningdate()+"...lastlyOperatedon"+acc.getLastlyoperatedon());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
