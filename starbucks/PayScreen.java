public class PayScreen implements Screen {

	AppController controller;

	public PayScreen(AppController controller) {
		this.controller = controller;
	}

	KeyPad keyPad = new KeyPad();

	@Override
	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(controller.MainScreen);
		}
	}

	@Override
	public String display() {
		return "Scan now";
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}
}
