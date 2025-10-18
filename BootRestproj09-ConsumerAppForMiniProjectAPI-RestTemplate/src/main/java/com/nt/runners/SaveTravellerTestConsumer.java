package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.webservices.client.WebServiceTemplateCustomizer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SaveTravellerTestConsumer implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		// base url
		String endPointUrl="http://localhost:8082/BootRestproj08-TouristAPI-MiniProject/traveller-api/save";
		//prepare json content
		String json_body="{\r\n"
				+ "    \"tname\": \"ms dhoni\",\r\n"
				+ "    \"taddrs\": \"Mumbai, Maharashtra\",\r\n"
				+ "    \"dob\": \"1990-04-30\",\r\n"
				+ "    \"mobileno\": 9876543210\r\n"
				+ "  }";
		//prepare json headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare request
		HttpEntity<String> request=new HttpEntity<String>(json_body,headers);
		//consume the endpoint
		ResponseEntity<String> response=template.postForEntity(endPointUrl, request, String.class);
		
		System.out.println("result is"+response.getBody());
		
		System.exit(0);

	}

}
