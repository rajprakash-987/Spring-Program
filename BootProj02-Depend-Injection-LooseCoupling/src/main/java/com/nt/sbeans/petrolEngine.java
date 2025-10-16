//petrol engine
package com.nt.sbeans;


import org.springframework.stereotype.Component;

@Component("pEngine")
public final class petrolEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("petrolEngine.startEngine()--Engine Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("petrolEngine.startEngine()--Engine Stoped");
		

	}

}
