package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	@Autowired
	private LocalDate ldt;
	
	//b.massage
	public String findSession() {
		int month=ldt.getMonthValue();
		if(month>=3 && month<=6)
			return "Summer Session";
		else if(month>=7 && month<=10) 
			return "Rainy seeion";
		else
			return "Winter Session";
	}
	

}
