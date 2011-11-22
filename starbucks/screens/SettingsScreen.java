package screens;

public class SettingsScreen extends ScreenBase {
	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 3) {
			controller.setScreen(new AddNewCardScreen());
		}
	}

	@Override
	public void display() {
		System.out.println("Manage Cards, Billing, Passcode, Show About & Terms");
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}
}
