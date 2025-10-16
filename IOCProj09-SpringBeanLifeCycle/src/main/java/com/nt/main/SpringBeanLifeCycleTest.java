package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.CheckingVotingEligibity;

public class SpringBeanLifeCycleTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		CheckingVotingEligibity voter=ctx.getBean("voter",CheckingVotingEligibity.class);
		try {
			String result=voter.checkEligibility();
			System.out.println(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ctx.close();
	}

}
