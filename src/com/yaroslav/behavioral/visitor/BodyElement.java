package com.yaroslav.behavioral.visitor;

public class BodyElement implements Element {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
