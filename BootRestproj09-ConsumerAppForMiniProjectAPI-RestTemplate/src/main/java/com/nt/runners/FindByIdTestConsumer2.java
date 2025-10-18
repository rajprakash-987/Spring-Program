package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.model.Traveller;

//@Component
public class FindByIdTestConsumer2 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		try {
		//String  url of the endpoint that you want to invoke
		String endPointUrl="http://localhost:8082/BootRestproj08-TouristAPI-MiniProject/traveller-api/find/{id}";
		//invoke the end point
		ResponseEntity<Traveller> response=template.getForEntity(endPointUrl, Traveller.class,1001);
		//display the response content
		System.out.println("The received result is::"+response.getBody());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.exit(0); 

	}

}
