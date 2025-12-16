package com.nt.ms;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderOperationsMs {
	
	@GetMapping("/show-season")
	public ResponseEntity<String> findSeson(){
		//get local date and time
		LocalDate ldt=LocalDate.now();
		//get current month
		int month=ldt.getMonthValue();
		String seasonName=null;
		if(month>=7 && month<=10) {
			seasonName="RainySeason";
		}
		else if(month>=3 && month<=6) {
			seasonName="SummerSeason";
		}
		else 
			seasonName="WinterSeson";
		
		//return response entity
		return new  ResponseEntity<String>(seasonName,HttpStatus.OK);
		
	}

}
