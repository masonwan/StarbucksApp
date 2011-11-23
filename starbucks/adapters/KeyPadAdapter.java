package adapters;

import widgets.KeyPad;

public class KeyPadAdapter {

	KeyPad keyPad = new KeyPad();

	public char press(int x, int y) {
		return keyPad.press(x, y - 4);
	}
}
