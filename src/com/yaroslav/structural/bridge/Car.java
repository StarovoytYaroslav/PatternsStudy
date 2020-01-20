package com.yaroslav.structural.bridge;

public abstract class Car {
	private Make make;
	protected Car(Make make) {
		this.make = make;
	}
	public void showDetails() {
		showType();
		make.setMake();
	}
	abstract protected void showType();
}
