package commands;

import core.*;
public abstract class CommandBase implements Command {
	protected AppController controller;
	
	public CommandBase(){
		controller = AppController.getAppController();
	}
}