package com.nt;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.EmployeeOperationController;
import com.nt.model.Employee;

@SpringBootApplication
//@ImportResource("com/nt/cfgs/applicationContext.xml") --no need because we are no more using xml we use the profile
public class BootProj10LayeredAppMiniprojectApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(BootProj10LayeredAppMiniprojectApplication.class, args);
		//get controller class obj ref
		EmployeeOperationController controller=ctx.getBean("empController",EmployeeOperationController.class);
		//read input from enduser
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the name");
//		String name=sc.next();
//		System.out.println("enter the desg");
//		String desg=sc.next();
//		System.out.println("enter the salary");
//		double salary=sc.nextDouble();
//		System.out.println("enter the deptno");
//		int deptno=sc.nextInt();
//		
//		//create employee obj
//		Employee emp1=new Employee();
//		emp1.setEname(name);emp1.setJob(desg);emp1.setSal(salary);emp1.setDeptno(deptno);
//		
//		try {
//			String resultMsg=controller.processEmployee(emp1);
//			System.out.println(resultMsg);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		//read input from enduser
		System.out.println("enter desg1");
		String desg1=sc.next();
		System.out.println("enter desg2");
		String desg2=sc.next();
		System.out.println("enter desg3");
		String desg3=sc.next();
		
	
		
		//invoke the bussiness method
		
		try {
			List<Employee> list=controller.processEmployessByDesg(desg1, desg2, desg3);
			list.forEach(emp->{
				System.out.println(emp);
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("internal problem try again");
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
