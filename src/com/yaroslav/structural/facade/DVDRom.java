package com.yaroslav.structural.facade;

public class DVDRom {
	private boolean data = false;
	
	public boolean hasData() {
		return data;
	}
	
	public void load() {
		System.out.println("Disc loaded");
		data = true;
	}
	
	public void unLoad() {
		System.out.println("Disc unLoaded");
		data = false;
	}
}
