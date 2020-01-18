package com.yaroslav.creational.factoryMethod;

public class RomeWatchMaker implements WatchMaker {

	@Override
	public Watch createWatch() {
		return new RomeWatch();
	}

}
