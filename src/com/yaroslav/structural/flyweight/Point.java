package com.yaroslav.structural.flyweight;

public class Point implements Shape {

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing point at: " + "( " + x + " ; " + y + " );");
	}
}
