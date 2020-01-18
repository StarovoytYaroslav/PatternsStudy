package com.yaroslav.behavioral.visitor;

public class EngineElement implements Element {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
