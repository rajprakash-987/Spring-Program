package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pinfo")
public class PersonInfo {
	@Value("${per.id}")
	private int id;
	@Value("${per.name}")
	private String name;
	@Value("${per.billamt}")
	private float amt;
	
	//injecting value directly
	@Value("hyd")
	private String adress="hyd";
	
	//injecting the system properties
	@Value("${os.name}")
	private String osName;
	@Value("${os.version}")
	private String osVer;
	
	//injecting enverment variable values
	@Value("${Path}")
	private String pathData;

	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", name=" + name + ", amt=" + amt + ", adress=" + adress + ", osName=" + osName
				+ ", osVer=" + osVer + ", pathData=" + pathData + "]";
	}

}
