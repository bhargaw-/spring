package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehical {
	
	@Autowired
	private Tyre tyre;
	public void vehicalName() {
		System.out.println("This is car class");
		this.tyre.setTyers(4);
		System.out.println(this.tyre);
	}
	
	
}
