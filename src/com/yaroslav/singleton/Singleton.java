package com.yaroslav.singleton;

public class Singleton {
	private int counter = 0;
	private static Singleton instance;
	private Singleton() {
		counter ++;
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public int getCounter() {
		return counter;
	}
	
}
