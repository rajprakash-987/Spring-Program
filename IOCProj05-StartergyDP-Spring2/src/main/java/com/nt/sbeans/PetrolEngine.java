package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pengine")
@Lazy(true)
public class PetrolEngine implements IEngine {
	@Override
	public void startEngine() {
		System.out.println("petrolengine :: petrolEngine Started");
	}
	
	@Override
	public void stopEngine() {
		System.out.println("petrolengine :: petrolEngine Stoped");
	}

}
