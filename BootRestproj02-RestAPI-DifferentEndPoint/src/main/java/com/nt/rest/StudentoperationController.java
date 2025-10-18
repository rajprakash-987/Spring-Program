package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-api")
public class StudentoperationController {
	
	//end point devlopment
	@GetMapping("/report")
	public ResponseEntity<String> showReport(){
		return new ResponseEntity<String>("Report Generation Process",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(){
		return new ResponseEntity<String>("Student Registrestion process", HttpStatus.CREATED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<String> editStudent(){
		return new ResponseEntity<String>("Student edit process(full modification)", HttpStatus.OK);
	}
	
	@PatchMapping("/emailUpdate")
	public ResponseEntity<String> editStudentEmail(){
		return new ResponseEntity<String>("Student edit process(Partial modification)", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(){
		return new ResponseEntity<String>("Student edit process(Partial modification)", HttpStatus.OK);
	}


}
