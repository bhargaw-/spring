package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MessageServiceConfiguration.class);
		MessagePrinter messagePrinter = applicationContext.getBean(MessagePrinter.class);
		messagePrinter.printMessage();
	}

}
