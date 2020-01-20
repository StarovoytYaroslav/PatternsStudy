package com.yaroslav.structural.flyweight;

public class Circle implements Shape {
	
	private int radius = 10;
	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing circle, with center at: " + "( " + x + " ; " + y + " ), and radius: " + radius + " ;");
	}
}
