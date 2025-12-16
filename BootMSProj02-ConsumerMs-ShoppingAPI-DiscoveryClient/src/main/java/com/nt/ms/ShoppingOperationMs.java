package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceClientComp;

@RestController
@RequestMapping("/shoping-api")
public class ShoppingOperationMs {
	@Autowired
	private BillingServiceClientComp client;
	
	@GetMapping("/purchase")
	public ResponseEntity<String> doShoping(){
		//invoke provide ms
		ResponseEntity<String> resp=client.invokeDoBillingEndPoint();
		//prepre final resu msg
		String resultMsg="shirt,Trouser are purchased with the bill amount::"+resp.getBody();
		//return the result
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		
	}

}
