package core;

import screens.*;

public class PasscodeDisplay implements Observer {

	@Override
	public void update(Object sender, Object arg) {
		((PinScreen) sender).display();
	}
}
