package com.yaroslav.behavioral.statehumanexample;

public class WeekEnd implements Activity {
	private int count = 0;
	@Override
	public void doSomething(Human human) {
		if (count < 3) {
			System.out.println("Chilling!!!!");
			count ++;
		} else
			human.setstate(new Work());
	}
}
