package com.yaroslav.command;

public class StartCommand implements Command{
	
	private Comp computer;
	
	public StartCommand(Comp computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.start();
	}
	
}
