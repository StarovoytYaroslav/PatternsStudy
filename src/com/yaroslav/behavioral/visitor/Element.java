package com.yaroslav.behavioral.visitor;

public interface Element {
	void accept(Visitor visitor);
}
