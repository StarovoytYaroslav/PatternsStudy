package com.yaroslav.visitor;

public class CarElement implements Element {

	private Element [] elements;
	
	public CarElement() {
		this.elements = new Element [] {new WheelElement("Front Left"), new WheelElement("Front Right"),
				new WheelElement("Rear Left"), new WheelElement("Rear Right"),
				new EngineElement(), new BodyElement()};
	}	
	@Override
	public void accept(Visitor visitor) {
		for (Element element : elements) {
			element.accept(visitor);
		}
		visitor.visit(this);
	}

}
