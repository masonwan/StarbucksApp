package widgets;

import java.util.*;

public class Pin {

	private char[] validKeys;

	public Pin(char[] validKeys) {
		this.validKeys = validKeys;
	}

	private ArrayList<Character> keys = new ArrayList<Character>();

	public char[] getKeys() {
		char[] temp = new char[keys.size()];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = keys.get(i);
		}

		return temp;
	}

	public void setKeys(char[] keys) {
		this.keys = new ArrayList<Character>();

		for (int i = 0; i < keys.length; i++) {
			this.keys.add(keys[i]);
		}
	}

	public boolean validate() {
		if (validKeys.length != keys.size())
			return false;

		for (int i = 0; i < validKeys.length; i++) {
			if (validKeys[i] != keys.get(i)) {
				return false;
			}
		}

		return true;
	}

	public boolean add(char key) {
		return keys.add(key);
	}

	public char remove() {
		return keys.remove(keys.size() - 1);
	}
}
