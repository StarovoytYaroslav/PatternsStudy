package com.yaroslav.visitor;

public class MechanicVisitor implements Visitor {

	@Override
	public void visit(EngineElement engine) {
		System.out.println("Check the engine");
	}

	@Override
	public void visit(BodyElement body) {
		System.out.println("Polish the body");
	}

	@Override
	public void visit(CarElement car) {
		System.out.println("Checked the look of the car");
	}

	@Override
	public void visit(WheelElement wheel) {
		System.out.println("Pumped up " + wheel.getName() + " wheel");
	}

}
