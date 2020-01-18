package com.yaroslav.behavioral.interpreter;

public class NumberExpression implements Expression {
	private int number;
	
	public NumberExpression(int number) {	
		this.number = number;
	}
	
	@Override
	public int interpret() {
		return number;
	}

	@Override
	public String toString() {
		return "NumberExpression [number=" + number + "]";
	}
	
}
