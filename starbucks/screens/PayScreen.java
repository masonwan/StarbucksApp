package screens;

import widgets.*;

public class PayScreen extends ScreenBase {
	KeyPad keyPad = new KeyPad();

	@Override
	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(new MainScreen());
		}
	}

	@Override
	public void display() {
		System.out.println("Scan now");
	}
}
