package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	
	@Bean(name="ld")
	public LocalDate ctreateDate() {
		return LocalDate.now();
	}

	public static void main(String[] args) {
		//contain creation
		ApplicationContext ctx =SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//grt target Spring bean class
		SeasonFinder sf=ctx.getBean("sf",SeasonFinder.class);
		String seasionName=sf.findSession();
		System.out.println("Seasion name :"+seasionName);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
