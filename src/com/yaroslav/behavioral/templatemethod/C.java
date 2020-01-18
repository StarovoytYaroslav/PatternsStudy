package com.yaroslav.behavioral.templatemethod;

public abstract class C {
	public void templateMethod() {
		System.out.print("1");
		differ();
		System.out.print("3");
		differ2();
	}
	protected abstract void differ();
	protected void differ2() {};
}
