package com.yaroslav.behavioral.statehumanexample;

public class Human {
	private Activity state;
	
	public void setstate(Activity state) {
		this.state = state;
	}
	
	public void doSomething() {
		state.doSomething(this);
	}
}
