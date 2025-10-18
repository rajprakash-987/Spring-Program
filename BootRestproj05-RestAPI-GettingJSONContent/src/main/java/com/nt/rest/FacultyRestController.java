package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;
import com.nt.model.Faculty;
import com.nt.model.Farmer;

@RestController
@RequestMapping("/faculty-api")
public class FacultyRestController {
	
	@PostMapping("/register-faculty")
	public ResponseEntity<String> showReport1(@RequestBody Faculty faculty){
		
		return new ResponseEntity<String>(faculty.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/register-farmer")
	public ResponseEntity<String> showReport(@RequestBody Farmer farmer){
		//return response entity
		return new ResponseEntity<String>(farmer.toString(),HttpStatus.OK);
	}
	@PostMapping("/register-customers")
	public ResponseEntity<String> showReport3(@RequestBody List<Customer> list){
		
		return new ResponseEntity<String>(list.toString(),HttpStatus.OK);
		
	}
}
