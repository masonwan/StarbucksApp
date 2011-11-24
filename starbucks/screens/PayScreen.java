package screens;

import widgets.KeyPad;

public class PayScreen extends ScreenBase {
	KeyPad keyPad = new KeyPad();

	@Override
	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(new MainScreen());
		} else if (x >= 1 && x <= 3 && y == 2) {
			controller.getCard().pay(1.5f);
		}
	}

	@Override
	public void display() {
		System.out.println("Scan now");
	}
}
