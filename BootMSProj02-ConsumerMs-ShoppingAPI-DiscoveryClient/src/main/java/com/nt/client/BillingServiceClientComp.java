package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceClientComp {
	@Autowired
	private DiscoveryClient client;
	
	public ResponseEntity<String> invokeDoBillingEndPoint(){
		//get provider ms service instance referencefrom eureka server
		List<ServiceInstance> listInstance=client.getInstances("Billing-Ms");
		//chhose the instamnce manually and gater required endpoint details
		ServiceInstance instance=listInstance.get(0);
		
		//gather provider ms service instance details
		URI uri=instance.getUri();//give base uri of the provider ms(http://localhost:8092/BillingMs
		//complete the endpoint details
		String epURL=uri+"/billingMs/billing-api/payment";
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> res=template.exchange(epURL, HttpMethod.GET,null,String.class);
		return res;
	}
}
