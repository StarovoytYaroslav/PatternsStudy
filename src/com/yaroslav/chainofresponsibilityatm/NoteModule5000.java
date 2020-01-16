package com.yaroslav.chainofresponsibilityatm;

public class NoteModule5000 extends NoteModule {

	@Override
	public void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.R5000;
		int remind = money.getAmt()%Note.R5000;
		if (countNote > 0)
			System.out.println("Выдано " + countNote + "купюр номиналом 5000");
		if (remind > 0 && next != null)
			next.takeMoney(new Money(remind));
	}

}
