package com.yaroslav.behavioral.chainofresponsibilityatm;

public class NoteModule100 extends NoteModule {

	@Override
	public void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.R100;
		int remind = money.getAmt()%Note.R100;
		if (countNote > 0)
			System.out.println("Выдано " + countNote + " купюр номиналом 100");
		if (remind > 0 && next != null)
			next.takeMoney(new Money(remind));

	}

}
