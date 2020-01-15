package com.yaroslav.builder;

public class FordMondeoBuilder extends CarBuilder {
	@Override
	public void buildMake() {
		car.setMake("Ford Mondeo");
	}
	@Override
	public void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}
	@Override
	public void buildMaxSpeed() {
		car.setMaxSpeed(260);
	}
}
