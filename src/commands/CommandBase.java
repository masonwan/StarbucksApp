package commands;

import widgets.*;

public abstract class CommandBase implements Command {
	protected final AppController controller = AppController.getAppController();
}