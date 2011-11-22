package commands;


import screens.*;

public class SettingsMenuCommand extends CommandBase {
	@Override
	public void execute() {
		if (controller.getScreen() instanceof PinScreen)
			return;
		controller.setScreen(new SettingsScreen());
	}
}