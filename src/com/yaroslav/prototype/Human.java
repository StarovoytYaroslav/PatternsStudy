package com.yaroslav.prototype;

public class Human implements Copyable {
	int age;
	String name;
	public Human(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public Object copy() {
		Human copy = new Human(age, name);
		return copy;
	}
	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}
	
}
