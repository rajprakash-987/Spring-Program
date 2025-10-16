package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("bdart")
public class BlueDart implements Courier {
	@Override
	public String deliver(int oid) {
		return oid+"order items are kept for delivary by blueDart";
		
		
		
	}

}
