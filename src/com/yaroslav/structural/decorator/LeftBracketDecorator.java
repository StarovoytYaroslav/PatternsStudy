package com.yaroslav.structural.decorator;

public class LeftBracketDecorator extends Decorator {
	
	public LeftBracketDecorator(PrinterInterface component) {
		super(component);
	}
	
	@Override
	public void print() {
		System.out.print("[");
		super.print();
	}
}
