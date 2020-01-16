package com.yaroslav.chainofresponsibility;

public class EmailLogger extends Logger {
	public EmailLogger(int priority) {
		super(priority);
	}
	
	@Override
	protected void write(String message) {
		System.out.println("Отправляем на почту: " + message);	
	}
}
