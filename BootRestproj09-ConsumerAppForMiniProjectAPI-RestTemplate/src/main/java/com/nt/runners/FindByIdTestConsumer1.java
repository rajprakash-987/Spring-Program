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
public class FindByIdTestConsumer1 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		try {
		//String  url of the endpoint that you want to invoke
		String endPointUrl="http://localhost:8082/BootRestproj08-TouristAPI-MiniProject/traveller-api/find/{id}";
		//invoke the end point
		ResponseEntity<String> response=template.getForEntity(endPointUrl, String.class,1001);
		//display the response content
		String jsonContent=response.getBody();
		System.out.println("The received result is::"+jsonContent);
		System.out.println("The received response status code::"+response.getStatusCode());
		System.out.println("The received response status code::"+response.getStatusCode().value());
		//use JACKSON API to convert received json content to model class object(de-serialization)
		ObjectMapper mapper=new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		Traveller traveller=mapper.readValue( jsonContent,Traveller.class);
		System.out.println("json to model class object ::"+traveller);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.exit(0); 

	}

}
