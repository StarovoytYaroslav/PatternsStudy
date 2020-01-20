package com.yaroslav.structural.flyweight;

public class Square implements Shape {

	private int side = 10;
	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing square with left upper conner coordinates at: " + "( " + x + " ; " + y + " ), and side: " + side + " ;");

	}

}
