package com.yaroslav.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
	private final static Map<String, Shape> shapes = new HashMap<String, Shape>();
	
	public Shape getShape(String shapeName) {
		Shape shape = shapes.get(shapeName);
		if (shape == null) {
			switch (shapeName) {
			case "Circle":
				shape = new Circle(); 
				break;
			case "Square":
				shape = new Square();
				break;
			case "Point":
				shape = new Point();
				break;
			}
			shapes.put(shapeName, shape);
		}
		return shape;
	}
}
