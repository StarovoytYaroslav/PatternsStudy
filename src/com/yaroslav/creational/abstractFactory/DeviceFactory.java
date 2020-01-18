package com.yaroslav.creational.abstractFactory;

public interface DeviceFactory {
	Mouse getMouse();
	Keyboard getKeyboard();
	TouchPad getTouchPad();
}
