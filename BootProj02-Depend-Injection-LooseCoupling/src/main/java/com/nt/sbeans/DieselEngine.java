//diesel engine
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public final class DieselEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("DieselEngine.startEngine()--Engine Started");

	}

	@Override
	public void stopEngine() {
		System.out.println("dieselEngine.startEngine()--Engine Stoped");
		

	}

}
