package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.sbeans.PatientDetails;

@SpringBootApplication
//@PropertySource("myfile.properties")
public class BootProj06ValueAnnotationSpellApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj06ValueAnnotationSpellApplication.class, args);
		//get patent details object
		PatientDetails details=ctx.getBean("pd",PatientDetails.class);
		//invoke the bussiness methods
		System.out.println(details);
		
		//close coitner
		((ConfigurableApplicationContext) ctx).close();
	}

}
