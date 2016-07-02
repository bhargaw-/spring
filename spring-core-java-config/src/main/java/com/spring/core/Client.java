package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.javaconfig.AppConfig;

public class Client {

	public static Tyre tyre;
	
	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Vehical vehical = ctx.getBean(Car.class);
		vehical.vehicalName();
		vehical = ctx.getBean(Bike.class);
		vehical.vehicalName();
		
	}

}
