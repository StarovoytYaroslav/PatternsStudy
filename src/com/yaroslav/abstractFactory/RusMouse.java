package com.yaroslav.abstractFactory;

public class RusMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("Щелчок мышью");
	}

	@Override
	public void dblClick() {
		System.out.println("Двойной щелчок мышью");
	}

	@Override
	public void scroll(int direction) {
		if (direction > 0)
			System.out.println("Скроллим вверх");
		else if (direction < 0)
			System.out.println("скроллим вниз");
		else 
			System.out.println("Не скроллим");

	}

}
