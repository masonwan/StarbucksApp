public class Pin {

	char[] keys = new char[4];

	public Pin(char[] keys) {
		for (int i = 0; i < keys.length; i++) {
			this.keys[i] = keys[i];
		}
	}

	public boolean validate(char[] keys) {
		if (keys.length != this.keys.length)
			return false;

		for (int i = 0; i < keys.length; i++) {
			if (this.keys[i] != keys[i]) {
				return false;
			}
		}

		return true;
	}
}
