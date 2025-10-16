package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dengine")
@Lazy(true)
public class DesielEngine implements IEngine {
	@Override
	public void startEngine() {
		System.out.println("desielengine :: desileEngine Started");
	}
	
	@Override
	public void stopEngine() {
		System.out.println("desileEngine :: desileEngine Stoped");
	}

}

