package com.yaroslav;

import com.yaroslav.behavioral.chainofresponsibility.EmailLogger;
import com.yaroslav.behavioral.chainofresponsibility.FileLogger;
import com.yaroslav.behavioral.chainofresponsibility.Level;
import com.yaroslav.behavioral.chainofresponsibility.Logger;
import com.yaroslav.behavioral.chainofresponsibility.SMSLogger;
import com.yaroslav.behavioral.chainofresponsibilityatm.Money;
import com.yaroslav.behavioral.chainofresponsibilityatm.NoteModule;
import com.yaroslav.behavioral.chainofresponsibilityatm.NoteModule100;
import com.yaroslav.behavioral.chainofresponsibilityatm.NoteModule1000;
import com.yaroslav.behavioral.chainofresponsibilityatm.NoteModule500;
import com.yaroslav.behavioral.chainofresponsibilityatm.NoteModule5000;
import com.yaroslav.behavioral.command.Comp;
import com.yaroslav.behavioral.command.ResetCommand;
import com.yaroslav.behavioral.command.StartCommand;
import com.yaroslav.behavioral.command.StopCommand;
import com.yaroslav.behavioral.command.User;
import com.yaroslav.behavioral.interpreter.Context;
import com.yaroslav.behavioral.interpreter.Expression;
import com.yaroslav.behavioral.iterator.Iterator;
import com.yaroslav.behavioral.iterator.Tasks;
import com.yaroslav.behavioral.memento.File;
import com.yaroslav.behavioral.memento.Game;
import com.yaroslav.behavioral.observer.ConsoleObserver;
import com.yaroslav.behavioral.observer.FileObserver;
import com.yaroslav.behavioral.observer.MeteoStation;
import com.yaroslav.behavioral.simplemediator.Admin;
import com.yaroslav.behavioral.simplemediator.SimpleUser;
import com.yaroslav.behavioral.simplemediator.TextChat;
import com.yaroslav.behavioral.statehumanexample.Human;
import com.yaroslav.behavioral.statehumanexample.Work;
import com.yaroslav.behavioral.stateradioexample.Radio;
import com.yaroslav.behavioral.stateradioexample.RadioDFM;
import com.yaroslav.behavioral.stateradioexample.Station;
import com.yaroslav.behavioral.templatemethod.B;
import com.yaroslav.behavioral.templatemethod.C;
import com.yaroslav.behavioral.visitor.BodyElement;
import com.yaroslav.behavioral.visitor.CarElement;
import com.yaroslav.behavioral.visitor.Element;
import com.yaroslav.behavioral.visitor.EngineElement;
import com.yaroslav.behavioral.visitor.HooliganVisitor;
import com.yaroslav.behavioral.visitor.MechanicVisitor;
import com.yaroslav.behavioral.visitor.Visitor;
import com.yaroslav.creational.abstractFactory.DeviceFactory;
import com.yaroslav.creational.abstractFactory.EngDeviceFactory;
import com.yaroslav.creational.abstractFactory.Mouse;
import com.yaroslav.creational.abstractFactory.RusDeviceFactory;
import com.yaroslav.creational.builder.Car;
import com.yaroslav.creational.builder.CarBuilder;
import com.yaroslav.creational.builder.Director;
import com.yaroslav.creational.builder.FordMondeoBuilder;
import com.yaroslav.creational.builder.SubaruBuilder;
import com.yaroslav.creational.builder.Transmission;
import com.yaroslav.creational.factoryMethod.DigitalWatchMaker;
import com.yaroslav.creational.factoryMethod.RomeWatchMaker;
import com.yaroslav.creational.factoryMethod.WatchMaker;
import com.yaroslav.creational.singleton.R;
import com.yaroslav.creational.singleton.Singleton;
import com.yaroslav.fundamental.delegate.Circle;
import com.yaroslav.fundamental.delegate.Painter;
import com.yaroslav.fundamental.delegate.Square;
import com.yaroslav.fundamental.simpledelegate.A;
import com.yaroslav.structural.bridge.Hatchback;
import com.yaroslav.structural.bridge.Kia;
import com.yaroslav.structural.bridge.Sedan;
import com.yaroslav.structural.bridge.Skoda;
import com.yaroslav.structural.composite.Composite;
import com.yaroslav.structural.composite.Shape;
import com.yaroslav.structural.composite.Triangle;
import com.yaroslav.structural.decorator.LeftBracketDecorator;
import com.yaroslav.structural.decorator.Printer;
import com.yaroslav.structural.decorator.PrinterInterface;
import com.yaroslav.structural.decorator.QuotesDecorator;
import com.yaroslav.structural.decorator.RightBracketDecorator;

public class Application {
	
	public static void main(String[] args) {
		decoratorTest();
	}
	// Factory Test
	public static WatchMaker getMakerByName(String maker) {
		if (maker.equals("Digital"))
			return new DigitalWatchMaker();
		else if (maker.equals("Rome"))
			return new RomeWatchMaker();

		throw new RuntimeException("Не поддерживаемая производственная линия: " + maker);
	}
	// Abstract Factory Test
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
	// Singleton Test
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
	// Chain of responsibility Test
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
	// Chain of responsibility ATM Test
	public static void chainOfResponsibilityAtmTest() {
		NoteModule nM5000 = new NoteModule5000();
		NoteModule nM1000 = new NoteModule1000();
		NoteModule nM500 = new NoteModule500();
		NoteModule nM100 = new NoteModule100();
		nM5000.setNext(nM1000);
		nM1000.setNext(nM500);
		nM500.setNext(nM100);
		nM5000.takeMoney(new Money(20100));
	}
	// Command Test
	public static void commandTest() {
		Comp c = new Comp();
		User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));
		u.startComputer();
		u.resetComputer();
		u.stopComputer();
	}
	// Delegate Test
	public static void delegateTest() {
		Painter p = new Painter();
		p.setGraphics(new Square());
		p.draw();
	}
	//Interpreter Test
	public static void interpreterTest() {
		Context c = new Context();
		Expression expr = c.evaluate("1-2+33");
		System.out.println(expr.interpret());
	}
	// Iterator Test
	public static void iteratorTest() {
		Tasks c = new Tasks();		
		Iterator it = c.getIterator();
		while(it.hasNext()) {
			System.out.println((String) it.next());
		}
	}
	// Simple mediator Test
	public static void simpleMediatorTest() {
		TextChat chat = new TextChat();
		Admin admin = new Admin(chat);
		SimpleUser user1 = new SimpleUser(chat);
		SimpleUser user2 = new SimpleUser(chat);
		SimpleUser user3 = new SimpleUser(chat);
		
		chat.setAdmin(admin);
		chat.addUser(user1);
		chat.addUser(user2);
		chat.addUser(user3);
		
		user1.sendMessage("Hi. i'm User1");
		admin.sendMessage("Daddy's Home!");
	}
	// Mediator Test
	public static void mediatorTest() {
		com.yaroslav.behavioral.mediator.TextChat chat = new com.yaroslav.behavioral.mediator.TextChat();
		com.yaroslav.behavioral.mediator.User admin = new com.yaroslav.behavioral.mediator.Admin(chat, "Ivan Ivanovich");
		com.yaroslav.behavioral.mediator.User u1 = new com.yaroslav.behavioral.mediator.SimpleUser(chat, "Vania");
		com.yaroslav.behavioral.mediator.User u2 = new com.yaroslav.behavioral.mediator.SimpleUser(chat, "Vova");
		com.yaroslav.behavioral.mediator.User u3 = new com.yaroslav.behavioral.mediator.SimpleUser(chat, "Sasha");
		
		chat.setAdmin(admin);
		chat.addUser(u1);
		chat.addUser(u2);
		chat.addUser(u3);
		
		u2.setEnable(false);
		
		admin.sendMessage("Hi there!");
	}
	// Memento Test
	public static void mementoTest() {
		Game game = new Game();
		game.set("LVL_1", 300000);
		System.out.println(game);
		
		File file = new File();
		file.setSave(game.save());
		game.set("LVL_25", 500000000);
		System.out.println(game);
		game.load(file.getSave());
		System.out.println(game);
	}
	// Observer Test
	public static void observerTest() {
		MeteoStation station = new MeteoStation();
		
		station.addObserver(new ConsoleObserver());
		station.addObserver(new FileObserver());
		
		station.setMeasurments(45, 2000);
	}
	// State radio example Test
	public static void stateRadioTest() {
		Station dfm = new RadioDFM();
		Radio radio = new Radio();
		radio.setStation(dfm);
		
		for (int i = 0; i < 10; i++) {
			radio.play();
			radio.nextStation();
		}
	}
	// State human example Test
	public static void stateTest() {
		Human secur = new Human();
		secur.setstate(new Work());
		for (int i = 0; i < 365; i++) {
			secur.doSomething();
		}
	}
	//Visitor Test
	public static void visitorTest() {
		Element car = new CarElement();
		
		Visitor hooligan = new MechanicVisitor();
		car.accept(hooligan);
		
	}
	//Template Method Example
	public static void templateMethodTest() {
		C a =new com.yaroslav.behavioral.templatemethod.A();
		C b = new B();
		a.templateMethod();
		System.out.println();
		b.templateMethod();
	}
	// Bridge Test
	public static void bridgeTest() {
		com.yaroslav.structural.bridge.Car c = new Hatchback(new Skoda());
		c.showDetails();
	}
	//Composite Test
	public static void compositeTest() {
		Composite c = new Composite();
		c.addComponent(new com.yaroslav.structural.composite.Circle());
		c.addComponent(new com.yaroslav.structural.composite.Circle());
		c.addComponent(new Triangle());
		c.addComponent(new com.yaroslav.structural.composite.Square());
		c.draw();
	}
	// Decorator Test
	public static void decoratorTest() {
		PrinterInterface printer = new RightBracketDecorator(new LeftBracketDecorator(new Printer("Hello")));
		printer.print();
	}
}
