
public class PayScreen implements AppScreen {
	KeyPad keyPad = new KeyPad();

	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			// Go to MainScreen.
		}
	}

	public String display() {
		return "Scan now";
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}
}
