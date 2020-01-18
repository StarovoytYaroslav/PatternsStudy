package com.yaroslav.creational.abstractFactory;

public class RusKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.print("Печатаем строку");
	}

	@Override
	public void println() {
		System.out.println("Печатаем строку с переводом строки");
	}
}
