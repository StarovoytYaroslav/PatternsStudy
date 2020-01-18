package com.yaroslav.behavioral.chainofresponsibilityatm;

public class NoteModule1000 extends NoteModule {

	@Override
	public void takeMoney(Money money) {
		int countNote = money.getAmt()/Note.R1000;
		int remind = money.getAmt()%Note.R1000;
		if (countNote > 0)
			System.out.println("������ " + countNote + " ����� ��������� 1000");
		if (remind > 0 && next != null)
			next.takeMoney(new Money(remind));

	}

}
