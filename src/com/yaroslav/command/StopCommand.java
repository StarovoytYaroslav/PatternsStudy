package com.yaroslav.command;

public class StopCommand implements Command {
	
	private Comp computer;
	
	public StopCommand(Comp computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.stop();
	}

}
