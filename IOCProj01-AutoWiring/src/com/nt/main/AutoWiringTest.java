package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class AutoWiringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("AutoWiringTest main method== start");
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("container created");
		
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		String msg=generator.generateMessage("raja");
		System.out.println(msg);
		
		ctx.close();
		System.out.println("\"AutoWiringTest main method== end");
		

	}
}
