package com.yaroslav.chainofresponsibility;

public class EmailLogger implements Logger {
	
	private int priority;
	Logger next;
	
	public EmailLogger(int priority) {
		this.priority = priority;
	}
	@Override
	public void setNext(Logger next) {
		this.next = next;
	}

	@Override
	public void writeMessage(String message, int level) {
		if (level <= priority)
			System.out.println("Отправляем на почту: " + message);
		if (next != null)
			next.writeMessage(message, level);
	}

}
