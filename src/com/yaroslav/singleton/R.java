package com.yaroslav.singleton;

// Class for testing singleton

public class R implements Runnable{

	@Override
	public void run() {
		Singleton.getInstance();
	}

}
