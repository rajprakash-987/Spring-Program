package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vahicle")
public class Vahicle {
	@Autowired
	@Qualifier("dengine")
	private IEngine engine;
	
	//bmethod
	public void journy(String place1,String place2) {
		engine.startEngine();
		System.out.println("i want to go "+place1+" "+place2);
		engine.stopEngine();
	}

}
