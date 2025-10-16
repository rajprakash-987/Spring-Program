package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class BootProj07BulkInjectionConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj07BulkInjectionConfigurationPropertiesAnnotationApplication.class, args);
		//get Spring bean class referance
		Company com=ctx.getBean("comp",Company.class);
		System.out.println(com);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
