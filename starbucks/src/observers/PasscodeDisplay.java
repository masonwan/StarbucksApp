package observers;

import screens.PinScreen;

public class PasscodeDisplay implements Observer {

	@Override
	public void update(Object sender) {
		PinScreen screen = (PinScreen) sender;
		screen.getHanlder().handle(screen, null);
	}
}
