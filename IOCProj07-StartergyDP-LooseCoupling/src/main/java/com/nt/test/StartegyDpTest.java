package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.FlipKart;

public class StartegyDpTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		FlipKart fpkt=ctx.getBean("fpkt",FlipKart.class);
		
		String msg=fpkt.shoping(new String[] {"shirt","truserr"}, new double[] {4000.0,5000.0});
		System.out.println(msg);
		
		ctx.close();
	}

}
