package screens;

import chains.Handler;
import adapters.KeyPadAdapter;

public class AddNewCardScreen extends ScreenBase {

	KeyPadAdapter keyPad = new KeyPadAdapter();

	// Chain of responsibility pattern.

	Handler handler;

	//

	char[] id = new char[16];
	int idIndex = 0;
	char[] code = new char[4];
	int codeIndex = 0;

	// Implement Screen

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
	public void display() {
		System.out.println(String.format("Enter a new card:\nID: %d Code: %d", id.toString(), code.toString()));
	}

	@Override
	public void topLeftCmd() {
		// Cancel the card.
	}

	@Override
	public void topRightCmd() {
		// Replace the card.
	}
}