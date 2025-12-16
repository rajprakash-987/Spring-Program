package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceClient;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingOperationMs {
	@Autowired
	private IBillingServiceClient client;
	
	@Value("${db.user}")
	private String user;
	
	@GetMapping("/shop")
	public ResponseEntity<String> doShoping(){
		ResponseEntity<String> res=client.invokeBillingMSEndPoint();
		String rsult="shirt price is"+res.getBody();
		return new ResponseEntity<String>("user is"+user+rsult,HttpStatus.OK);
	}

}


