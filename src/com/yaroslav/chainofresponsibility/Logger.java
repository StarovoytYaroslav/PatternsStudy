package com.yaroslav.chainofresponsibility;

public interface Logger {
	void writeMessage(String message, int level);
	void setNext(Logger next);
}
