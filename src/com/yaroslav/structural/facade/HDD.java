package com.yaroslav.structural.facade;

public class HDD {
	public void copyFromDVD(DVDRom dvd) {
		if (dvd.hasData())
			System.out.println("Copy data from dvd");
		else 
			System.out.println("Insert dvd with data");
	}
}
