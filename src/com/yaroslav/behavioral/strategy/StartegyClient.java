package com.yaroslav.behavioral.strategy;

public class StartegyClient {
	private Sorting strategy;

	public void setStaregy(Sorting strategy) {
		this.strategy = strategy;
	}
	public void exexcuteStrategy(int [] arr) {
		strategy.sort(arr);
	}

}
