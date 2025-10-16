package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("voter")
@PropertySource("com/nt/commons/info.properties")
public class CheckingVotingEligibity {
	@Value("${voter.id}")
	private Integer id;
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private Integer age;
	
	private Date verfiedOn;
	
	public CheckingVotingEligibity() {
		System.out.println("checkingvotingeligibility 0 param constuctor");
	   }
	@PostConstruct   //init lifecyle method
	public void myInit() {
		System.out.println("checking voting eligiblity:myinit");
		//intialize leftover properties
		verfiedOn=new Date();
		//validation logic
		if(name==null || age<=0) {
			throw new IllegalArgumentException("set curent value to name,age properties");
		}
	}
	//b.logic
			public String checkEligibility() {
				System.out.println("checking voting eligiblity:checkEligibility");
				if(age<18)
					return "Mr/Miss/Mrs."+name+"you are not eligible for voting---->verified on::"+verfiedOn;
				else
					return "Mr/Miss/Mrs."+name+"you are eligible for voting---->verified on::"+verfiedOn;
			}
			
	@PreDestroy //destroy life cycle method
	public void myDestroy() {
		System.out.println("checking voting eligiblity:my Destroy");
		//nullification of the bean properties
		name=null;
		age=null;
		verfiedOn=null;
		id=null;
	}
		
		
	

}
