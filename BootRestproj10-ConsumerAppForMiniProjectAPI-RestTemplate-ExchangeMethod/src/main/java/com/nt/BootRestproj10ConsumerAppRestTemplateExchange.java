package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootRestproj10ConsumerAppRestTemplateExchange {
	
	@Bean(name="template")
	public RestTemplate createTemplete() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootRestproj10ConsumerAppRestTemplateExchange.class, args);
	}

}
