package com.nt.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;
import com.nt.model.Faculty;
import com.nt.model.Farmer;
import com.nt.model.Land;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/faculty-api")
public class FacultyRestController {
	
	@GetMapping("/report1")
	public ResponseEntity<Faculty> showReport1(){
		Faculty faculty=new Faculty();
		faculty.setFid(100);faculty.setFname("raj");
		faculty.setAddrs("balaso");faculty.setQlfy("btech");
		faculty.setSubject("math");
		
		return new ResponseEntity<Faculty>(faculty,HttpStatus.OK);
	}
	
	@GetMapping("/report2")
	public ResponseEntity<Farmer> showReport(){
		//creare obj
		Land land=new Land(1234,"10Acr","Budvel","wet");
		Farmer farmer=new Farmer(1001,"raj","balasore",new String[] {"red","green","yellow"},true,"corn",
																List.of("rajesh","nani"),
																Set.of(98765L,4321L),
																Map.of("adhar",454545,"pan",789987),
																land);
		//return response entity
		return new ResponseEntity<Farmer>(farmer,HttpStatus.OK);
	}
	@GetMapping("/report3")
	public ResponseEntity<List<Customer>> showReport3(){
		List<Customer> list=new ArrayList<>();
		Customer cust1=new Customer(100,"raj","bls",90f);
		Customer cust2=new Customer(101,"raj3sh","ctk",90f);
		Customer cust3=new Customer(102,"mahesh","kolkata",90f);
		list.add(cust1);
		list.add(cust3);
		list.add(cust2);
		
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		
	}
}
