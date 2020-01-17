package com.yaroslav.simplemediator;

public class SimpleUser implements User {
	private Chat chat;
	
	public SimpleUser(Chat chat) {
		this.chat = chat;
	}

	@Override
	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}

	@Override
	public void getMessage(String message) {	
		System.out.println("User receives message: " + message);
	}

}
