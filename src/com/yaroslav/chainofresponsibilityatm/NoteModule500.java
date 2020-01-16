package com.yaroslav.chainofresponsibilityatm;

public class NoteModule500 extends NoteModule {

	@Override
	public void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.R500;
		int remind = money.getAmt()%Note.R500;
		if (countNote > 0)
			System.out.println("Выдано " + countNote + " купюр номиналом 500");
		if (remind > 0 && next != null)
			next.takeMoney(new Money(remind));

	}

}
