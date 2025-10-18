package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("sessonService")
public class SessionFinderServiceImpl implements ISessionFinderSService {

	@Override
	public String FindSession() {
		//get sys date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current month 
		int month=ldt.getMonthValue();
		if(month>=6 && month<=10) {
			return "rainy session";
		}
		else if(month>=3 && month<=5) {
			return "Summer sesson";
		}
		else
			return "winter session";
		
	}

}
