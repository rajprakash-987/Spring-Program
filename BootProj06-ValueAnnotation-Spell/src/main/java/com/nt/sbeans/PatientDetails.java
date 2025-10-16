package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pd")
@Data
public class PatientDetails {
	@Value("1000")
	private Integer pid;
	
	//collecting values from application.properties file
	@Value("${pat.name}")
	private String pname;
	
	@Value("${pat.addrs}")
	private String paddrs;
	
	@Value("${pat.age}")
	private Integer page;
	
	//collectiong values from system file
	@Value("${user.name}")
	private String user;
	@Value("${os.name}")
	private String os;
	
	//collecting values from envierment variables
	@Value("${path}")
	private String pathData;
	
	@Value("#{dc._3dEchoPrice+dc.ctscanPrice+dc.xrayPrice}")
	private Float billAmount;
	
	@Value("#{dc.ctscanPrice>=10000}")
	private boolean ctScanOverPriced;

	
	
	

}
