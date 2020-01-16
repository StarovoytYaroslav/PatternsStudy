package com.yaroslav.chainofresponsibilityatm;

public class Money {
	private int amt;

	public Money(int amt) {
		this.amt = amt;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		if (amt > 0 && amt <= 200_000 && amt % Note.R100 == 0)
			this.amt = amt;
		else 
			throw new RuntimeException("����� ����� ������ ���� �� ����� 200_000 � ������ 100");
	}
	
	
}
