package com.yaroslav.behavioral.observer;

public interface Observed {
	void addObserver(Observer o);
	void remobeObserver(Observer o);
	void notifyObservers();
}
