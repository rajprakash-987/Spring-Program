package com.nt.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Traveller {
	private Integer tid;
	private String tname;
	private String taddrs;
	private LocalDate dob;
	private Long mobileno;

}
