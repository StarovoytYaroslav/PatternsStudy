package com.yaroslav.builder;

public class Director {
	private CarBuilder builder;
	public void setBuilder(CarBuilder builder) {
		this.builder = builder;
	}
	
	public Car buildCar() {
		builder.createCar();
		builder.buildMake();
		builder.buildTransmission();
		builder.buildMaxSpeed();
		Car car = builder.getCar();
		return car;
	}
}
