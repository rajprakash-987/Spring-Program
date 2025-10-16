package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class FlipKart {
	@Autowired
	@Qualifier("shipper")
	private Courier courier;
	
	
	public String shoping(String items[],double prices[]) {
		//calculate the bill amount
		double billAmount=0.0;
		for(double p:prices) {
			billAmount=billAmount+p;
		}
		
		//generate order id
		int oid=new Random().nextInt(1000);
		
		//deliver the product using order id
		String msg=courier.deliver(oid);
		
		return Arrays.toString(items)+"items with bill amount:::"+billAmount+"--"+msg;
	}

}
