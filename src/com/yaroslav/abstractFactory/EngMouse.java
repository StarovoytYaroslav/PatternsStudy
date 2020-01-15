package com.yaroslav.abstractFactory;

public class EngMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("Mouse click");
	}

	@Override
	public void dblClick() {
		System.out.println("Mouse double click");
	}

	@Override
	public void scroll(int direction) {
		if(direction > 0)
			System.out.println("Scrolls UP");
		else if (direction < 0)
			System.out.println("Scrolls DOWN");
		else 
			System.out.println("No scrolling");
	}

}
