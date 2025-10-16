package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
//@Data
@Setter
@ToString
@ConfigurationProperties(prefix="org.nit")
public class Company {
	private Integer id;
	private String name;
	private String address;
	private Integer size;
	private String mail;
	
	private String[] colors;
	private List<String> branches;
	private Set<Long> phones;
	private Map<String,Long>idDetails;
	private Supplier supplier;
}
