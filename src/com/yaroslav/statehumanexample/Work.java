package com.yaroslav.statehumanexample;

public class Work implements Activity {

	@Override
	public void doSomething(Human human) {
		System.out.println("Working!!!");
		human.setstate(new WeekEnd());
	}

}
