package com.yaroslav.chainofresponsibility;

public class SMSLogger implements Logger {
	private int priority;
	Logger next;
	
	public SMSLogger(int priority) {
		this.priority = priority;
	}
	@Override
	public void setNext(Logger next) {
		this.next = next;
	}

	@Override
	public void writeMessage(String message, int level) {
		if (level <= priority)
			System.out.println("яля: " + message);
		if (next != null)
			next.writeMessage(message, level);
	}

}
