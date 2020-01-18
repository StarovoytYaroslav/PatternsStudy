package com.yaroslav.behavioral.visitor;

public class HooliganVisitor implements Visitor {

	@Override
	public void visit(EngineElement engine) {
		System.out.println("Start the engine");
	}

	@Override
	public void visit(BodyElement body) {
		System.out.println("Knoking on the body");
	}

	@Override
	public void visit(CarElement car) {
		System.out.println("Smoked inside car");
	}

	@Override
	public void visit(WheelElement wheel) {
		System.out.println("Hit " + wheel.getName() + " wheel");
	}

}
