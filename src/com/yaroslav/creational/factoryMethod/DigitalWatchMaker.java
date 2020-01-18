package com.yaroslav.creational.factoryMethod;

public class DigitalWatchMaker implements WatchMaker {
	@Override
	public Watch createWatch() {
		return new DigitalWatch();
	}

}
