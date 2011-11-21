public class OptionsScreen implements Screen {

	AppController controller;

	public OptionsScreen(AppController controller) {
		this.controller = controller;
	}

	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 7) {
			controller.setScreen(controller.MoreOptionsScreen);
		}
	}

	@Override
	public String display() {
		return "Reload, Refresh Balance, or More options";
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}
}
