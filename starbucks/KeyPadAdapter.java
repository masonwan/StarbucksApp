public class KeyPadAdapter implements IKeyPadAdapter {
	KeyPad keyPad;

	public KeyPadAdapter(KeyPad keyPad) {
		this.keyPad = keyPad;
	}

	public char press(int x, int y) {
		return keyPad.press(x, y - 4);
	}
}
