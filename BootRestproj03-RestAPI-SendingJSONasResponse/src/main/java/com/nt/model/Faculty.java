package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
	private Integer fid;
	private String fname;
	private String qlfy;
	private String subject;
	private String addrs;

}
