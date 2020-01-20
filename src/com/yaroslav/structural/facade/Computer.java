package com.yaroslav.structural.facade;

public class Computer {
	private Power pwr = new Power();
	private DVDRom dvd = new DVDRom();
	private HDD hdd = new HDD();
	
	public void copy() {
		pwr.on();
		dvd.load();
		hdd.copyFromDVD(dvd);
		dvd.unLoad();
		pwr.off();
	}
}
