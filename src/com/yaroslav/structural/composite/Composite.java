package com.yaroslav.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape {
	private List<Shape> components = new ArrayList<Shape>();
	
	public void addComponent(Shape component) {
		components.add(component);
	}
	
	public void removeComponent(Shape component) {
		components.remove(component);
	}
	@Override
	public void draw() {
		System.out.println("Hello I'm composite");
		for (Shape shape : components) {
			shape.draw();
		}
	}

}
