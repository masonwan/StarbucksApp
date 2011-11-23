package states;

import screens.*;

public class TwoPins extends PinStateBase {
	public TwoPins(PinScreen screen) {
		super(screen);
	}

	@Override
	public void handle(char pressedKey) {
		if (pressedKey >= '0' && pressedKey <= '9') {
			pin.add(pressedKey);
			screen.setState(new ThreePins(screen));
		} else if (pressedKey == 'X') {
			pin.remove();
			screen.setState(new OnePin(screen));
		}
	}
}