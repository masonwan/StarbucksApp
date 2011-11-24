package commands;

public class MenuInvoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		if (command != null)
			command.execute();
	}
}
