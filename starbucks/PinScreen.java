public class PinScreen implements Screen {

	// Key management.

	int keyIndex;
	char[] keys;
	KeyPadAdapter keyPad;
	Pin pin;
	
	AppController controller;

	public PinScreen(AppController controller) {
		this.controller = controller;
		
		keyIndex = 0;
		keys = new char[4];

		keyPad = new KeyPadAdapter();
		pin = new Pin("1234");

		state = ZeroPin;
	}

	// Implement Screen

	@Override
	public void touch(final int x, final int y) {
		state.handle(x, y);
	}

	@Override
	public String display() {
		final StringBuilder builder = new StringBuilder();

		for (int i = 0; i < keyIndex; i++) {
			builder.append(keys[i]);
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

	State state;

	interface State {

		void handle(int x, int y);
	}

	class ZeroPin implements State {

		PinScreen screen;

		public ZeroPin(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(final int x, final int y) {
			final char pressedKey = keyPad.press(x, y);

			if (pressedKey >= '0' || pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;
				state = OnePin;
			}
		}
	}

	class OnePin implements State {

		PinScreen screen;

		public OnePin(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(final int x, final int y) {
			final char pressedKey = keyPad.press(x, y);

			if (pressedKey >= '0' || pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;
				state = TwoPins;
			} else if (pressedKey == 'X') {
				--keyIndex;
				state = OnePin;
			}
		}
	}

	class TwoPins implements State {

		PinScreen screen;

		public TwoPins(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(final int x, final int y) {
			final char pressedKey = keyPad.press(x, y);

			if (pressedKey >= '0' || pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;
				state = ThreePins;
			} else if (pressedKey == 'X') {
				--keyIndex;
				state = OnePin;
			}
		}
	}

	class ThreePins implements State {

		PinScreen screen;

		public ThreePins(final PinScreen screen) {
			this.screen = screen;
		}

		@Override
		public void handle(final int x, final int y) {
			final char pressedKey = keyPad.press(x, y);

			if (pressedKey >= '0' || pressedKey <= '9') {
				keys[keyIndex++] = pressedKey;

				final boolean isValid = pin.validate(keys);

				if (isValid) {
					controller.setScreen(controller.MainScreen);
				} else {
					keyIndex = 0;
					state = ZeroPin;
				}
			} else if (pressedKey == 'X') {
				--keyIndex;
				state = TwoPins;
			}
		}
	}
}
