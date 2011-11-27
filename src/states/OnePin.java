package states;

import screens.*;

public class OnePin extends PinStateBase {
	public OnePin(PinScreen screen) {
		super(screen);
	}

	@Override
	public void handle(char pressedKey) {
		if (pressedKey >= '0' && pressedKey <= '9') {
			pin.add(pressedKey);
			screen.setState(new TwoPins(screen));
		} else if (pressedKey == 'X') {
			pin.remove();
			screen.setState(new ZeroPin(screen));
		}
	}
}
