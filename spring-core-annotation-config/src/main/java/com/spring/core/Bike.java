package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehical {

	@Autowired
	private Tyre tyre;
	public void vehicalName() {
		System.out.println("This is bike class");
		this.tyre.setTyers(2);
		System.out.println(this.tyre);
	}
}