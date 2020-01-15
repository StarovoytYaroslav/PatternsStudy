package com.yaroslav.abstractFactory;

public interface DeviceFactory {
	Mouse getMouse();
	Keyboard getKeyboard();
	TouchPad getTouchPad();
}
