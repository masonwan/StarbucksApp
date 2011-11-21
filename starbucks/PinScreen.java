import java.util.ArrayList;

public class PinScreen implements Screen, Subject {

	// Key management.

	int keyIndex;
	char[] keys;
	KeyPadAdapter keyPad;
	Pin pin;

	AppController controller;
	PasscodeDisplay passcodeDisplay;

	public PinScreen(AppController controller) {
		this.controller = controller;

		keyIndex = 0;
		keys = new char[4];

		keyPad = new KeyPadAdapter();
		pin = new Pin("1234".toCharArray());

		setState(ZeroPin);

		attach(passcodeDisplay = new PasscodeDisplay());
	}

	// Implement Screen

	@Override
	public void touch(final int x, final int y) {
		state.handle(keyPad.press(x, y));
	}

	@Override
	public String display() {
		final StringBuilder builder = new StringBuilder();

		for (int i = 0; i < keyIndex; i++) {
			builder.append('*');
		}

		return builder.toString();
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}

	// State pattern.

	public final ZeroPin ZeroPin = new ZeroPin(this);
	public final OnePin OnePin = new OnePin(this);
	public final TwoPins TwoPins = new TwoPins(this);
	public final ThreePins ThreePins = new ThreePins(this);

	private State state;

	public State setState(State state) {
		this.state = state;
		inform();

		return this.state;
	}

	public State getState() {
		return state;
	}

	interface State {

		void handle(char pressedKey);
	}

	class ZeroPin implements State {

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

	class OnePin implements State {

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

	class TwoPins implements State {

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

	class ThreePins implements State {

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
					controller.setScreen(controller.MainScreen);
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

	@Override
	public void inform() {
		for (Observer observer : observers) {
			observer.update(this, keyIndex);
		}
	}
}
