package com.yaroslav.behavioral.chainofresponsibility;

public class FileLogger extends Logger {
		
	public FileLogger(int priority) {
		super(priority);
	}
	
	@Override
	protected void write(String message) {
		System.out.println("Записываем в файл: " + message);
	}
}
