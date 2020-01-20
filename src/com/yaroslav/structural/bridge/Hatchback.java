package com.yaroslav.structural.bridge;

public class Hatchback extends Car {

	public Hatchback(Make make) {
		super(make);
	}

	@Override
	protected void showType() {
		System.out.println("Hatchback type");
	}
	
}
