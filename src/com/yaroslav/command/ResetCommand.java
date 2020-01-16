package com.yaroslav.command;

public class ResetCommand implements Command {

	private Comp computer;
	
	public ResetCommand(Comp computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.reset();
	}

}
