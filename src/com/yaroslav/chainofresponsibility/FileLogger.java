package com.yaroslav.chainofresponsibility;

public class FileLogger implements Logger {

	private int priority;
	Logger next;
	
	public FileLogger(int priority) {
		this.priority = priority;
	}
	@Override
	public void setNext(Logger next) {
		this.next = next;
	}

	@Override
	public void writeMessage(String message, int level) {
		if (level <= priority)
			System.out.println("Записываем в файл: " + message);
		if (next != null)
			next.writeMessage(message, level);
	}

}
