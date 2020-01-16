package com.yaroslav.chainofresponsibilityatm;

public abstract class NoteModule {
	
	protected NoteModule next;
	
	public abstract void takeMoney(Money money);
	
	public void setNext(NoteModule next) {
		this.next = next;
	}
}
