package com.yaroslav.creational.abstractFactory;

public class RusDeviceFactory implements DeviceFactory {

	@Override
	public Mouse getMouse() {
		return new RusMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		return new RusKeyboard();
	}

	@Override
	public TouchPad getTouchPad() {
		return new RusTouchPad();
	}

}
