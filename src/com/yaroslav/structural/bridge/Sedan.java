package com.yaroslav.structural.bridge;

public class Sedan extends Car {

	public Sedan(Make make) {
		super(make);
	}

	@Override
	protected void showType() {
		System.out.println("Sedan type");
	}

}
