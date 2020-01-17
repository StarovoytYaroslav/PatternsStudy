package com.yaroslav.observer;

import java.util.ArrayList;
import java.util.List;

public class MeteoStation implements Observed {
	
	private int temperature;
	private int pressure;

	List<Observer> observers = new ArrayList<Observer>();
	
	public void setMeasurments(int temperature, int pressure) {
		this.temperature = temperature;
		this.pressure = pressure;
		notifyObservers();
	}
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);	
	}

	@Override
	public void remobeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.handleEvent(temperature, pressure);
		}
	}

}
