package com.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
public class MessageServiceConfiguration {
	
	public MessageService getMessageService(){
		return new MessageServiceImpl();
	}
}
