public class Pin {

	char[] keys;

	public Pin(String keys) {
		this.keys = keys.toCharArray();
	}

	public boolean validate(String keys) {
		if (keys.length() != this.keys.length)
			return false;

		for (int i = 0; i < keys.length(); i++) {
			if (this.keys[i] != keys.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}
