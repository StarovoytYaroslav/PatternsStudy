package com.yaroslav.behavioral.mediator;

public abstract class User {
	private Chat chat;
	private String name;
	private boolean isEnable = true;
	
	public boolean isEnable() {
		return isEnable;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public User(Chat chat, String name) {
		this.chat = chat;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}
	
	public abstract void getMessage(String message);

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
}
