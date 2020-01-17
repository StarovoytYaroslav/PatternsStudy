package com.yaroslav.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileObserver implements Observer {
	@Override
	public void handleEvent(int temperature, int pressure) {
		File f;
		try {
			f = File.createTempFile("TempPressure", ".txt");
			PrintWriter pw = new PrintWriter(f);
			pw.print("The weather has changed. The temperature is: " + temperature + ", the pressure is: " + pressure + ".");
			pw.println();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
