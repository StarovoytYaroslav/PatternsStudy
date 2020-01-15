package com.yaroslav.abstractFactory;

public class EngDeviceFactory implements DeviceFactory {

	@Override
	public Mouse getMouse() {
		return new EngMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		return new EngKeyboard();
	}

	@Override
	public TouchPad getTouchPad() {
		return new EngTouchPad();
	}

}
