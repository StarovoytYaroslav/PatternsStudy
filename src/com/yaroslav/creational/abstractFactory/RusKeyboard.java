package com.yaroslav.creational.abstractFactory;

public class RusKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.print("�������� ������");
	}

	@Override
	public void println() {
		System.out.println("�������� ������ � ��������� ������");
	}
}
