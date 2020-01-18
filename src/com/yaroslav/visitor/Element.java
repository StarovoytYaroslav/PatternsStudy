package com.yaroslav.visitor;

public interface Element {
	void accept(Visitor visitor);
}
