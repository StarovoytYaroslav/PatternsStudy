package com.yaroslav;

import com.yaroslav.abstractFactory.DeviceFactory;
import com.yaroslav.abstractFactory.EngDeviceFactory;
import com.yaroslav.abstractFactory.Mouse;
import com.yaroslav.abstractFactory.RusDeviceFactory;
import com.yaroslav.builder.Car;
import com.yaroslav.builder.CarBuilder;
import com.yaroslav.builder.Director;
import com.yaroslav.builder.FordMondeoBuilder;
import com.yaroslav.builder.SubaruBuilder;
import com.yaroslav.builder.Transmission;
import com.yaroslav.chainofresponsibility.EmailLogger;
import com.yaroslav.chainofresponsibility.FileLogger;
import com.yaroslav.chainofresponsibility.Level;
import com.yaroslav.chainofresponsibility.Logger;
import com.yaroslav.chainofresponsibility.SMSLogger;
import com.yaroslav.chainofresponsibilityatm.Money;
import com.yaroslav.chainofresponsibilityatm.NoteModule;
import com.yaroslav.chainofresponsibilityatm.NoteModule100;
import com.yaroslav.chainofresponsibilityatm.NoteModule1000;
import com.yaroslav.chainofresponsibilityatm.NoteModule500;
import com.yaroslav.chainofresponsibilityatm.NoteModule5000;
import com.yaroslav.factoryMethod.DigitalWatchMaker;
import com.yaroslav.factoryMethod.RomeWatchMaker;
import com.yaroslav.factoryMethod.WatchMaker;
import com.yaroslav.singleton.R;
import com.yaroslav.singleton.Singleton;

public class Application {

	public static void main(String[] args) {
		chainOfResponsibilityAtmTest();
	}
	// Factory
	public static WatchMaker getMakerByName(String maker) {
		if (maker.equals("Digital"))
			return new DigitalWatchMaker();
		else if (maker.equals("Rome"))
			return new RomeWatchMaker();

		throw new RuntimeException("Не поддерживаемая производственная линия: " + maker);
	}
	// Abstract Factory
	public static DeviceFactory getFactoryByCountryCode(String lang) {
		switch(lang) {
			case "RU":
				return new RusDeviceFactory();
			case "EN":
				return new EngDeviceFactory();
			default:
				throw new RuntimeException("Не поддерживаемая страна : " + lang);
		}
	}
	// Builder
	public static void builder() {
		Director dir = new Director();
		dir.setBuilder(new FordMondeoBuilder());
		Car car = dir.buildCar();
		System.out.println(car.toString());
	}
	// Singleton
	public static void singleton() {
		Singleton s = Singleton.getInstance();
		s = Singleton.getInstance();
		s = Singleton.getInstance();
		System.out.println(s.counter);	
	}
	// Singleton Test
	public static void singletonTest() {
		Thread t[] = new Thread[1000];
		
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new R());
			t[i].start();
		}
		for (int i = 0; i < t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Singleton.counter);
	}

	public static void chainOfResponsibilityTest() {
		String message = "Все хорошо";
		int level = Level.ERROR;
		Logger smsLog = new SMSLogger(Level.ERROR);
		Logger fileLog = new FileLogger(Level.INFO);
		Logger emailLog = new EmailLogger(Level.DEBUG);
		fileLog.setNext(emailLog);
		smsLog.setNext(fileLog);
		smsLog.writeMessage(message, level);
	}

	public static void chainOfResponsibilityAtmTest() {
		NoteModule nM5000 = new NoteModule5000();
		NoteModule nM1000 = new NoteModule1000();
		NoteModule nM500 = new NoteModule500();
		NoteModule nM100 = new NoteModule100();
		nM5000.setNext(nM1000);
		nM1000.setNext(nM500);
		nM500.setNext(nM100);
		nM5000.takeMoney(new Money(21600));
	}
}

