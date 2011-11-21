public class AddNewCardScreen implements Screen {

	KeyPadAdapter keyPad = new KeyPadAdapter();
	AppController controller;

	public AddNewCardScreen(AppController controller) {
		this.controller = controller;
	}

	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 3) {
			// Focus on id.
		} else if (x == 2 && y == 4) {
			// Focus on code.
		} else if (x >= 1 && x <= 3 && y >= 5 && y <= 8) {
			char pressedKey = keyPad.press(x, y);

			// Append to id or code.
		}
	}

	@Override
	public String display() {
		StringBuilder builder = new StringBuilder();

		builder.append("Enter a new card:");
		builder.append(String.format("ID: %1 Code: %2", id.toString(),
				code.toString()));
		// Display the current card number and pins.

		return "";
	}

	@Override
	public void topLeftCmd() {
		// Cancel the card.
	}

	@Override
	public void topRightCmd() {
		// Replace the card.
	}

	// Chain of responsibility pattern.

	char[] id = new char[16];
	int idIndex = 0;
	char[] code = new char[4];
	int codeIndex = 0;
}

interface Handler {
	void handle(char pressedKey);

	Handler setNext(Handler handler);
}

class IdHandler implements Handler {
	Handler nextHandler;

	@Override
	public void handle(char pressedKey) {
		// TODO: Handle key.

		if (nextHandler != null) {
			nextHandler.handle(pressedKey);
		}
	}

	@Override
	public Handler setNext(Handler handler) {
		return nextHandler = handler;
	}
}

class CodeHandler implements Handler {
	Handler nextHandler;

	@Override
	public void handle(char pressedKey) {
		// TODO: Handle key.

		if (nextHandler != null) {
			nextHandler.handle(pressedKey);
		}
	}

	@Override
	public Handler setNext(Handler handler) {
		return nextHandler = handler;
	}
}
