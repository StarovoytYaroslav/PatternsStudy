package com.yaroslav.behavioral.chainofresponsibility;

public abstract class Logger {
	protected Logger next;
	protected int priority; 
	public void writeMessage(String message, int level) {	
		if (level <= priority)
			write(message);
		if (next != null)
			next.writeMessage(message, level);
	}
	protected abstract void write(String message);
	public void setNext(Logger next) {
		this.next = next;
	}
	public Logger(int priority) {
		this.priority = priority;
	}

}
