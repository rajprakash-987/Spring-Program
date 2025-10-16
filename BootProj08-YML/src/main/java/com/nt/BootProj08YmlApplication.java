package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.EmployeeDetails;

@SpringBootApplication
public class BootProj08YmlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj08YmlApplication.class, args);
		EmployeeDetails ed=ctx.getBean("emp",EmployeeDetails.class);
		System.out.println(ed);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
