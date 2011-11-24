package adapters;

import widgets.*;

public class KeyPadAdapter {

	private KeyPad keyPad = new KeyPad();

	public char press(int x, int y) {
		return keyPad.press(x, y - 4);
	}
}
