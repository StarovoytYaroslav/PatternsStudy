package com.yaroslav.builder;

public abstract class CarBuilder {
	protected Car car;
	public Car createCar() {
		return car = new Car();
	}

	protected abstract void buildMake();
	protected abstract void buildTransmission();
	protected abstract void buildMaxSpeed();

	public Car getCar() {
		return car;
	}
		
}
