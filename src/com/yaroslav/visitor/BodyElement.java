package com.yaroslav.visitor;

public class BodyElement implements Element {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
