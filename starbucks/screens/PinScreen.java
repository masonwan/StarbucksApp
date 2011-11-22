package screens;

import core.*;

import java.util.ArrayList;

public class PinScreen extends ScreenBase implements Subject {

	// Key management.

	private int keyIndex;
	private char[] keys;
	private Pin pin;

	public int getNumKeys() {
		return keyIndex;
	}

	private KeyPadAdapter keyPad;

	public KeyPadAdapter getKeyPad() {
		return keyPad;
	}

	private PasscodeDisplay passcodeDisplay;
	private Handler handler;

	public PinScreen() {
		keyIndex = 0;
		keys = new char[4];

		keyPad = new KeyPadAdapter();
		pin = new Pin("1234".toCharArray());

		setState(ZeroPin);

		attach(passcodeDisplay = new PasscodeDisplay());

		handler = new PinScreenTouchHandler();
		handler.setNext(new PinScreenDisplayHandler());
	}

	// Implement Screen

	@Override
	public void touch(int x, int y) {
		handler.handle(this, new int[] { x, y });
		// state.handle(keyPad.press(x, y));
	}

	@Override
	public void display() {
		handler.handle(this, null);

		// StringBuilder builder = new StringBuilder();
		//
		// for (int i = 0; i < keyIndex; i++) {
		// builder.append('*');
		// }
		//
		// System.out.println(builder.toString());
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}

	// PinState pattern.

	public final ZeroPin ZeroPin = new ZeroPin(this);
	public final OnePin OnePin = new OnePin(this);
	public final TwoPins TwoPins = new TwoPins(this);
	public final ThreePins ThreePins = new ThreePins(this);

	private PinState state;

	public PinState setState(PinState state) {
		this.state = state;
		inform();

		return this.state;
	}

	public PinState getState() {
		return state;
	}

	class ZeroPin implements PinState {

		PinScreen screen;

		public ZeroPin(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(char pressedKey) {
			if (pressedKey >= '0' && pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;
				setState(OnePin);
			}
		}
	}

	class OnePin implements PinState {

		PinScreen screen;

		public OnePin(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(char pressedKey) {
			if (pressedKey >= '0' && pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;
				setState(TwoPins);
			} else if (pressedKey == 'X') {
				--keyIndex;
				setState(ZeroPin);
			}
		}
	}

	class TwoPins implements PinState {

		PinScreen screen;

		public TwoPins(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(char pressedKey) {
			if (pressedKey >= '0' && pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;
				setState(ThreePins);
			} else if (pressedKey == 'X') {
				--keyIndex;
				setState(OnePin);
			}
		}
	}

	class ThreePins implements PinState {

		PinScreen screen;

		public ThreePins(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(char pressedKey) {
			if (pressedKey >= '0' && pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;

				boolean isValid = pin.validate(keys);

				if (isValid) {
					controller.setScreen(new MainScreen());
				} else {
					keyIndex = 0;
					setState(ZeroPin);
				}
			} else if (pressedKey == 'X') {
				--keyIndex;
				setState(TwoPins);
			}
		}
	}

	// Implement Subject interface.
	// Observer pattern.

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	/**
	 * Inform the observers to update their data.
	 */
	@Override
	public void inform() {
		for (Observer observer : observers) {
			observer.update(this, keyIndex);
		}
	}
}
