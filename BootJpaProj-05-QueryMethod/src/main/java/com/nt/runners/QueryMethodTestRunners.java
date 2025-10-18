package com.nt.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IEmployeeRepository;

@Component
public class QueryMethodTestRunners implements CommandLineRunner {
	@Autowired
	private IEmployeeRepository employeeRepo;
	@Override
	public void run(String... args) throws Exception {
//		employeeRepo.showAllEmployees().forEach(System.out::println);
//		employeeRepo.showEmpsBySalaryRange(1000.0, 20000.0).forEach(System.out::println);
		
//		employeeRepo.fetchEmpsBySalaryRange(3000.0, 12000.0).forEach(System.out::println);
//		employeeRepo.loadEmpsBySalaryRange(3000.0, 12000.0).forEach(System.out::println);
		
		/*employeeRepo.showEmpByDesgs("CLERK", "MANAGER", "SALESMAN").forEach(System.out::println);
		System.out.println("----------------------------------------");
		employeeRepo.showEmpDataByDesg("CLERK", "MANAGER", "SALESMAN").forEach(row->{
			for(Object val:row) {
				System.out.println(val+"  ");
			}
			System.out.println();
		});
		
		System.out.println("-----------------------------------------");
		
		employeeRepo.showEmpNameByNameChars("r%").forEach(System.out::println);*/
		
		/*System.out.println("single record::"+employeeRepo.fetchEmpByName("WARD"));
		System.out.println("----------------------------------------");
		Object data=employeeRepo.fetchEmpDataByName("WARD");
		Object row[]=(Object[])data;
		System.out.println("single record multiple value::"+Arrays.toString(row));
		System.out.println("----------------------------------------");
		System.out.println("single record single value::"+employeeRepo.fetchEmpSalaryByName("WARD"));*/
		
		/*System.out.println("unique emp names count ::"+employeeRepo.showEmpsCount());
		Object row[]=(Object[])employeeRepo.showAgregateData();
		System.out.println("aggregate data::"+Arrays.toString(row));*/
		
		/*int count=employeeRepo.hikeSalaryByDesg("clerk", 5.0f);
		System.out.println("no of records that are affected "+count);*/
		
		/*int count=employeeRepo.removeEmpsBySalaryRange(24000.0, 26000.0);
		System.out.println("no of records that are removed:: "+count);*/
		
		LocalDateTime ldt=employeeRepo.showSystemDate();
		System.out.println("Date and time"+ldt);
		
		

	}

}
