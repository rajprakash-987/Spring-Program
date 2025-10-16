package com.nt.sbeans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	@Autowired
 private LocalTime lt;
 
 public WishMessageGenerator() {
	 System.out.println("WishMessageGenerator :: 0 arg constuctor");
 }
 public String generateMessage(String user) {
	 int hour=lt.getHour();
	 if(hour<12) 
		 return "goodmorning"+user;
		 
	else if(hour<16) 
			 return "good afternoon"+user;
			 
	   else if(hour<20)
		   return "good evening"+user;
	   else
		   return "good night"+user;
 }
}
