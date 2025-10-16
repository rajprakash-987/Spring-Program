package com.nt.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Vahicle;

public class StategyDpTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class)	;
		Vahicle vahicle=ctx.getBean("vahicle", Vahicle.class);
		vahicle.journy("hyd","goa");
		ctx.close();
	}
}
