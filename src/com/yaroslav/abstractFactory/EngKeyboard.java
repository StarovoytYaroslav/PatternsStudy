package com.yaroslav.abstractFactory;

public class EngKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.print("Print");
	}

	@Override
	public void println() {
		System.out.println("Print line");
	}

}
