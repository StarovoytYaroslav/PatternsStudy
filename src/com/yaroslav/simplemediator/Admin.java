package com.yaroslav.simplemediator;

public class Admin implements User {
	private Chat chat;
	
	public Admin(Chat chat) {
		this.chat = chat;
	}

	@Override
	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("Admin receives message: " + message);
	}
}
