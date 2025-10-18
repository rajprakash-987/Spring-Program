package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.BootJpaProj07AssociationMappingApplication;
import com.nt.service.ICustomerMgmtService;

@Component
public class AssociationMappingTestRunner implements CommandLineRunner {

    private final BootJpaProj07AssociationMappingApplication bootJpaProj07AssociationMappingApplication;
	@Autowired
	private ICustomerMgmtService custService;

    AssociationMappingTestRunner(BootJpaProj07AssociationMappingApplication bootJpaProj07AssociationMappingApplication) {
        this.bootJpaProj07AssociationMappingApplication = bootJpaProj07AssociationMappingApplication;
    }

	@Override
	public void run(String... args) throws Exception {
		/*try {
			String msg=custService.saveDataUsingParent();
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//*************************************************************
		/*try {
			String msg=custService.saveDataUsingChilds();
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//***************************************************************
		/*try {
			custService.loadDataUsingParent();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//**************************************************************
		/*try {
			custService.loadDataUsingChilds();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//***************************************************************
		/*try {
			custService.deleteDataUsingParent();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//****************************************************************
		/*try {
			custService.deleteAllChildsOfAParent();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//****************************************************************
		/*try {
			custService.addNewChildToExistingChilds();
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		//****************************************************************
		/*try {
			custService.deleteDataUsingChilds();
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		//***************************************************************
		try {
			custService.showParentsToChildsDataUsingJoins().forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
