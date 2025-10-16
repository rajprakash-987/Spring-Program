package com.nt.main;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class SpringI18nTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//gather local details from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("enter language code");
		String lang=sc.next();
		System.out.println("enter country code::");
		String country=sc.next();
		//prepare local obj data
		Locale locale=new Locale (lang,country);
		//get the messages local specific property file
		String msg1=ctx.getMessage("nit.welcome",new String[] {},"aa",locale);
		String msg2=ctx.getMessage("nit.bye",new String[] {},"bb",locale);
		String msg3=ctx.getMessage("nit.wishes",new String[] {},"cc",locale);
		
		//print the message
		System.out.println(msg1+" "+msg2+" "+msg3);
		sc.close();
		ctx.close();

	}
}
	


