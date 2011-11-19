public class SettingsScreen implements Screen {

	AppController controller;

	public SettingsScreen(AppController controller) {
		this.controller = controller;
	}

	public void touch(int x, int y) {
		if (y == 3) {
			// Go to AddNewCardScreen.
		}
	}

	public String display() {
		return "Add Starbucks Cards, Delete Starbucks Cards, Billing Information, Starbucks Cards Account";
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}
}
