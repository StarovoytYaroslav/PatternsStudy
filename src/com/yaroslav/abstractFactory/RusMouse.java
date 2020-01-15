package com.yaroslav.abstractFactory;

public class RusMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("������ �����");
	}

	@Override
	public void dblClick() {
		System.out.println("������� ������ �����");
	}

	@Override
	public void scroll(int direction) {
		if (direction > 0)
			System.out.println("�������� �����");
		else if (direction < 0)
			System.out.println("�������� ����");
		else 
			System.out.println("�� ��������");

	}

}
