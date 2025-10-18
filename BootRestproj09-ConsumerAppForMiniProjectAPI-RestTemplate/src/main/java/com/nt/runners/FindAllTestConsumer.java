package com.nt.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.nt.model.Traveller;

//@Component
public class FindAllTestConsumer implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		/*// base url
		String endPointUrl="http://localhost:8082/BootRestproj08-TouristAPI-MiniProject/traveller-api/all";
		//consume endpoint
		ResponseEntity<String> response=template.getForEntity(endPointUrl, String.class);
		//display the content
		String jsonContent=response.getBody();
		System.out.println("the result(json) is"+jsonContent);
		
		//convert the json content to list<T> object
		ObjectMapper mapper=new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		List<Traveller> list=mapper.readValue(jsonContent, new TypeReference<List<Traveller>>() {});
		System.out.println("List of Travellers are::"+list);*/
		
		
		// base url
		String endPointUrl="http://localhost:8082/BootRestproj08-TouristAPI-MiniProject/traveller-api/all";
		//consume endpoint
		Class<? extends List> clazz=new ArrayList<Traveller>().getClass();
		ResponseEntity<? extends List> response=template.getForEntity(endPointUrl, clazz);
		System.out.println("java result::"+response.getBody());

	}

}
