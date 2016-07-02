package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static Tyre tyre;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Vehical vehical = context.getBean(Car.class);
		vehical.vehicalName();
		
		vehical = context.getBean(Bike.class);
		vehical.vehicalName();
	}

}
