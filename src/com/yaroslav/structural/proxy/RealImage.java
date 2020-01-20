package com.yaroslav.structural.proxy;

public class RealImage implements Image {
	
	private String file;
	
	public RealImage(String file) {
		this.file = file;
		load();
	}
	
	public void load() {
		System.out.println("Loading image");
	}
	
	@Override
	public void display() {
		System.out.println("Viewing image");
	}
	
}
