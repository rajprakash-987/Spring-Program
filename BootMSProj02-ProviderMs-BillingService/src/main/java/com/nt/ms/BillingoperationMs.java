package com.nt.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingoperationMs {
	
	@GetMapping("/payment")
	public ResponseEntity<String>  dobilling(){
		int billAmt=new Random().nextInt(2000000);
		return new ResponseEntity<String>("Bill Amount is"+billAmt,HttpStatus.OK);
	}

}
