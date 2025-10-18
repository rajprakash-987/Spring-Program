package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Traveller;
import com.nt.service.ITravellerMgmtService;

@RestController
@RequestMapping("/traveller-api")
public class TravellerControllerRestOperation {
	@Autowired
	private ITravellerMgmtService travellerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Traveller traveller){
		try {
			String msg=travellerService.registerTraveller(traveller);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllTravellers(){
		try {
			List<Traveller> list=travellerService.showAlltraveller();
			return new ResponseEntity<List<Traveller>>(list, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> showTravellerById(@PathVariable int id){
		try {
			Traveller traveller=travellerService.fetchTravellerById(id);
			return new ResponseEntity<Traveller>(traveller, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<?> modifyTraveller(@RequestBody Traveller traveller){
		try {
			//use service
			String msg=travellerService.updateTraveller(traveller);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/{id}/{addrs}")
	public ResponseEntity<?> modifyTravellerAddress(@PathVariable int id,@PathVariable String addrs){
		try {
			//use service
			String msg=travellerService.updateTravellerAddress(id, addrs);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll/{minAge}")
	public ResponseEntity<?> showTravellersByAge(@PathVariable int minAge){
		try {
			//use service
			List<Traveller> list=travellerService.showTravellersByAge(minAge);
			return new ResponseEntity<List<Traveller>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
