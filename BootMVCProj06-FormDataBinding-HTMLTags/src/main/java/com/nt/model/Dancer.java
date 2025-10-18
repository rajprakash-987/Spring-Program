package com.nt.model;

import lombok.Data;

@Data
public class Dancer {
	private Integer did;
	private String name;
	private String addrs;
	private String danceForm;
	private Float fee;
	
	public Dancer() {
		System.out.println("Dance:: 0-param constuctor");
	}
	
}
