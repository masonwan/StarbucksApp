package commands;

import screens.*;

public class RewardsMenuCommand extends CommandBase {
	@Override
	public void execute() {
		if (controller.getScreen() instanceof PinScreen)
			return;
		controller.setScreen(new RewardsScreen());
	}
}