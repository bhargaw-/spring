package com.spring.core;

public class Tyre {

	private int tyers;

	public int getTyers() {
		return tyers;
	}

	public void setTyers(int tyers) {
		this.tyers = tyers;
	}
	
	@Override
	public String toString() {
		return this.getClass() +" has "+  tyers + "tyers.";
	}
}
