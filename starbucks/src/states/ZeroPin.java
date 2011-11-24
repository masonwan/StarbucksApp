package states;

import screens.*;

public class ZeroPin extends PinStateBase {
	public ZeroPin(PinScreen screen) {
		super(screen);
	}

	@Override
	public void handle(char pressedKey) {
		if (pressedKey >= '0' && pressedKey <= '9') {
			pin.add(pressedKey);
			screen.setState(new OnePin(screen));
		}
	}
}