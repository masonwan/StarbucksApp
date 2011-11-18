public class PinScreen implements AppScreen {
	public final ZeroPin ZeroPin = new ZeroPin(this);
	public final OnePin OnePin = new OnePin(this);
	public final TwoPins TwoPins = new TwoPins(this);
	public final ThreePins ThreePins = new ThreePins(this);

	IState state;

	char[] keys = new char[4];
	KeyPad keyPad;
	Pin pin;

	public PinScreen() {
		keyPad = new KeyPad();
		pin = new Pin("1234");

		state = this.ZeroPin;
	}

	public void touch(int x, int y) {
		state.handle(x, y);
	}

	public String display() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < keys.length; i++) {
			builder.append('*');
		}

		return builder.toString();
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}

	// State pattern

	interface IState {
		void handle(int x, int y);
	}

	class ZeroPin implements IState {
		PinScreen screen;

		public ZeroPin(PinScreen screen) {
			this.screen = screen;
		}

		public void handle(int x, int y) {
			char pressedKey = keyPad.press(x, y);

			if (pressedKey >= '0' || pressedKey <= '9') {
				keyPad.
			}
		}
	}

	class OnePin implements IState {
		PinScreen screen;

		public OnePin(PinScreen screen) {
			this.screen = screen;
		}

		public void handle(int x, int y) {

		}
	}

	class TwoPins implements IState {
		PinScreen screen;

		public TwoPins(PinScreen screen) {
			this.screen = screen;
		}

		public void handle(int x, int y) {

		}
	}

	class ThreePins implements IState {
		PinScreen screen;

		public ThreePins(PinScreen screen) {
			this.screen = screen;
		}

		public void handle(int x, int y) {

		}
	}
}
