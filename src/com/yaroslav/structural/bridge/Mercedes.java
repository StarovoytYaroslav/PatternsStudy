package com.yaroslav.structural.bridge;

public class Mercedes implements Make {

	@Override
	public void setMake() {
		System.out.println("Mercedes car");
	}

}
