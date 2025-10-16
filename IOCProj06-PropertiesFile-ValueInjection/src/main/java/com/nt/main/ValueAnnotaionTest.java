package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.PersonInfo;

public class ValueAnnotaionTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class)	;//ioc con creation
		PersonInfo info=ctx.getBean("pinfo",PersonInfo.class);//getr spring bean class object
		System.out.println(info);
		
		ctx.close();//close the container
	}

}
