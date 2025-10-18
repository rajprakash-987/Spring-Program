package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome-api")
public class WelcomeOperationsRestController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> showWelcomemessage(){
		return new ResponseEntity<String>("welcome toSpring Boot Rest", HttpStatus.OK);
	}

}
