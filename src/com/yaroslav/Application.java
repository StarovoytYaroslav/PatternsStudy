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
import com.yaroslav.factoryMethod.DigitalWatchMaker;
import com.yaroslav.factoryMethod.RomeWatchMaker;
import com.yaroslav.factoryMethod.WatchMaker;

public class Application {

	public static void main(String[] args) {
		
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
	
	public static void builder() {
		Director dir = new Director();
		dir.setBuilder(new FordMondeoBuilder());
		Car car = dir.buildCar();
		System.out.println(car.toString());
	}
}
