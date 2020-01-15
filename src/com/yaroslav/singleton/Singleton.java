package com.yaroslav.singleton;

public class Singleton {
	public static int counter = 0;
	private static volatile Singleton instance = null;
	private Singleton() {
		counter ++;
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}