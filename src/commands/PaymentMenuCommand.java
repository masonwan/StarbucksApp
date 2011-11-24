package commands;

import screens.*;

public class PaymentMenuCommand extends CommandBase {
	@Override
	public void execute() {
		if (controller.getScreen() instanceof PinScreen)
			return;
		controller.setScreen(new PaymentsScreen());
	}
}