package com.yaroslav.fundamental.delegate;

public class Painter {
	private Graphics graphics;
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	public void draw() {
		graphics.draw();
	}
}
