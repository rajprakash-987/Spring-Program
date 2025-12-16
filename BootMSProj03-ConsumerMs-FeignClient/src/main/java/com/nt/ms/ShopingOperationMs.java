package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceClient;

@RestController
@RequestMapping("/shoping-api")
public class ShopingOperationMs {
	@Autowired
	private IBillingServiceClient client;
	
	@GetMapping("/shop")
	public ResponseEntity<String> doShoping(){
		ResponseEntity<String> res=client.invokeDopayment();
		String finalamt="shirt price is"+res.getBody();
		return new ResponseEntity<String>(finalamt,HttpStatus.OK);
		
	}
}
