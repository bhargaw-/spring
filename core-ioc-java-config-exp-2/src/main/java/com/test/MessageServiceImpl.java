package com.test;

import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

	public String getMessage() {
		return "Welcome to sprinng IOC tutorial";
	}

}
