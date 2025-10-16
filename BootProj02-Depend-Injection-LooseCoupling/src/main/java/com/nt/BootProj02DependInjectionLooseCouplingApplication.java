package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj02DependInjectionLooseCouplingApplication {

	public static void main(String[] args) {
		 ApplicationContext ctx = SpringApplication.run(BootProj02DependInjectionLooseCouplingApplication.class, args);
		 
		 //get target spring bean class
		 Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		 
		 //invoke the beasness method
		 vehicle.journey("hyd","odi");
		 
		 //close the container
		 ((ConfigurableApplicationContext) ctx).close();
	}

}
