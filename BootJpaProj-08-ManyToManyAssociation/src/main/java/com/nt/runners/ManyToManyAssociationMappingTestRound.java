package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICollageMgmtService;

@Component
public class ManyToManyAssociationMappingTestRound implements CommandLineRunner {
	@Autowired
	private ICollageMgmtService collegeservice;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			collegeservice.saveDataUsingParent();
			
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		//********************************************
		/*try {
			collegeservice.loadDataUsingParent();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//***********************************************
		try {
			collegeservice.deleteDataUsingParent();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
