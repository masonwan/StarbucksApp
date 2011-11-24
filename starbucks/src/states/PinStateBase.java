package states;

import screens.PinScreen;
import widgets.*;

public abstract class PinStateBase implements PinState {

	protected final PinScreen screen;
	protected final Pin pin;

	public PinStateBase(PinScreen screen) {
		this.screen = screen;
		pin = screen.getPin();
	}
}
