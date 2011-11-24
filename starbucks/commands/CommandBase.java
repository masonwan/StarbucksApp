package commands;

import widgets.AppController;

public abstract class CommandBase implements Command {
	protected AppController controller;

	public CommandBase() {
		controller = AppController.getAppController();
	}
}