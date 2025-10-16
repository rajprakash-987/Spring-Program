package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	@Qualifier("motor")
	@Autowired //field injection
	private IEngine engg;
	
	//b method
	public void journey(String startPlace ,String endPlace) {
		System.out.println("Vehicle.journy():--->journey stated from ::"+startPlace);
		engg.startEngine();
		System.out.println("Vehicle.journy():--->journey ended here ::"+endPlace);
		engg.stopEngine();
	}

}
