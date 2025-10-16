package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public class DTDC implements Courier {
	public String deliver(int oid) {
		return oid+"order items are kept for delivary by DTDC";
	}

}
