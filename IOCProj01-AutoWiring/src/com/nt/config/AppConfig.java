package com.nt.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.nt.sbeans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("app config o argument constuctor");
	}
	@Bean(name="ltime")
	public LocalTime createLTime() {
		return LocalTime.now();
	}

}
