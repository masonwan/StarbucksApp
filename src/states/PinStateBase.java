package states;

import screens.*;
import widgets.*;

public abstract class PinStateBase implements State {

	protected final PinScreen screen;
	protected final Pin pin;

	public PinStateBase(PinScreen screen) {
		this.screen = screen;
		pin = screen.getPin();
	}
}
