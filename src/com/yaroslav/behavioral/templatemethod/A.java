package com.yaroslav.behavioral.templatemethod;

public class A extends C {

	@Override
	protected void differ() {
		System.out.print("2");
	}
	@Override
	protected void differ2() {
		System.out.print("5");
	}
}
