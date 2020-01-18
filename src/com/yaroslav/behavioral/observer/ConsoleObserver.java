package com.yaroslav.behavioral.observer;

public class ConsoleObserver implements Observer {
	@Override
	public void handleEvent(int temperature, int pressure) {
		System.out.println("The weather has changed. The temperature is: " + temperature + ", the pressure is: " + pressure + ".");
	}

}
