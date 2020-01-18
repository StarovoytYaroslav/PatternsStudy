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
import com.yaroslav.command.Comp;
import com.yaroslav.command.ResetCommand;
import com.yaroslav.command.StartCommand;
import com.yaroslav.command.StopCommand;
import com.yaroslav.command.User;
import com.yaroslav.delegate.Painter;
import com.yaroslav.delegate.Square;
import com.yaroslav.factoryMethod.DigitalWatchMaker;
import com.yaroslav.factoryMethod.RomeWatchMaker;
import com.yaroslav.factoryMethod.WatchMaker;
import com.yaroslav.interpreter.Context;
import com.yaroslav.interpreter.Expression;
import com.yaroslav.iterator.Tasks;
import com.yaroslav.memento.File;
import com.yaroslav.memento.Game;
import com.yaroslav.observer.ConsoleObserver;
import com.yaroslav.observer.FileObserver;
import com.yaroslav.observer.MeteoStation;
import com.yaroslav.simplemediator.Admin;
import com.yaroslav.simplemediator.SimpleUser;
import com.yaroslav.simplemediator.TextChat;
import com.yaroslav.iterator.Iterator;
import com.yaroslav.singleton.R;
import com.yaroslav.singleton.Singleton;
import com.yaroslav.statehumanexample.Human;
import com.yaroslav.statehumanexample.Work;
import com.yaroslav.stateradioexample.Radio;
import com.yaroslav.stateradioexample.RadioDFM;
import com.yaroslav.stateradioexample.Station;
import com.yaroslav.visitor.BodyElement;
import com.yaroslav.visitor.CarElement;
import com.yaroslav.visitor.Element;
import com.yaroslav.visitor.EngineElement;
import com.yaroslav.visitor.HooliganVisitor;
import com.yaroslav.visitor.MechanicVisitor;
import com.yaroslav.visitor.Visitor;

public class Application {
	
	public static void main(String[] args) {
		visitorTest();
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
		com.yaroslav.mediator.TextChat chat = new com.yaroslav.mediator.TextChat();
		com.yaroslav.mediator.User admin = new com.yaroslav.mediator.Admin(chat, "Ivan Ivanovich");
		com.yaroslav.mediator.User u1 = new com.yaroslav.mediator.SimpleUser(chat, "Vania");
		com.yaroslav.mediator.User u2 = new com.yaroslav.mediator.SimpleUser(chat, "Vova");
		com.yaroslav.mediator.User u3 = new com.yaroslav.mediator.SimpleUser(chat, "Sasha");
		
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
}
