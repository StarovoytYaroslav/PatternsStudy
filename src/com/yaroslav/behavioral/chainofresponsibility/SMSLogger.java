package com.yaroslav.behavioral.chainofresponsibility;

public class SMSLogger extends Logger{

	public SMSLogger(int priority) {
		super(priority);
	}

	@Override
	protected void write(String message) {
		System.out.println("яля: " + message);
	}
}
