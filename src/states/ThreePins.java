package states;

import screens.*;
import widgets.*;

public class ThreePins extends PinStateBase {
	public ThreePins(PinScreen screen) {
		super(screen);
	}

	@Override
	public void handle(char pressedKey) {
		if (pressedKey >= '0' && pressedKey <= '9') {
			pin.add(pressedKey);

			boolean isValid = pin.validate();
			AppController controller = AppController.getAppController();

			if (isValid) {
				controller.setScreen(new MainScreen());
			} else {
				pin.setKeys(new char[0]);
				screen.setState(new ZeroPin(screen));
			}
		} else if (pressedKey == 'X') {
			pin.remove();
			screen.setState(new TwoPins(screen));
		}
	}
}