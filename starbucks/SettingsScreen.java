public class SettingsScreen implements Screen {

	AppController controller;

	public SettingsScreen(AppController controller) {
		this.controller = controller;
	}

	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 3) {
			controller.setScreen(controller.AddNewCardScreen);
		}
	}

	@Override
	public String display() {
		return "Manage Cards, Billing, Passcode, Show About & Terms";
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}
}
