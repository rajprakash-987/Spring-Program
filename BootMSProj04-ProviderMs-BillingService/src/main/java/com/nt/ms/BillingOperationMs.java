package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationMs {
	
	@Value("${db.user}")
	private String user;
	
	@GetMapping("/payment")
	public ResponseEntity<String> doBilling(){
		int billAmt=new Random().nextInt(2000000);
		return new ResponseEntity<String>("bill amt is:: "+user+billAmt,HttpStatus.OK);
	}
	
}
