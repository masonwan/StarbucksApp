public class OptionsScreen implements Screen {

	AppController controller;

	public OptionsScreen(AppController controller) {
		this.controller = controller;
	}

	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 7) {
			controller.setScreen(controller.MoreOptionsScreen);
		}
	}

	public String display() {
		return "Reload, Refresh Balance, or More options";
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}
}
