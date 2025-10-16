//diesel engine
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("CNGEngine")
public final class CNGEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("CNGEngine.startEngine()--Engine Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("CNGEngine.startEngine()--Engine Stoped");
		

	}

}
