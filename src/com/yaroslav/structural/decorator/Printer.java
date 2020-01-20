package com.yaroslav.structural.decorator;

public class Printer implements PrinterInterface {
	
	private String value;
	
	public Printer(String value) {
		this.value = value;
	}

	@Override
	public void print() {
		System.out.print(value);
	}
}
