package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.webservices.client.WebServiceTemplateCustomizer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UpdateTravellerTestConsummer implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		// base url
		String endPointUrl="http://localhost:8082/BootRestproj08-TouristAPI-MiniProject/traveller-api/update/{id}/{addrs}";
		
		//consume the endpoint
		ResponseEntity<String> response=template.exchange(endPointUrl,
															HttpMethod.PATCH,
															null, String.class,1020,"12,Ameerpate,india");
		
		System.out.println("result is"+response.getBody());
		
		System.exit(0);

	}

}
