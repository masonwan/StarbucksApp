public class PayScreen implements Screen {

	AppController controller;

	public PayScreen(AppController controller) {
		this.controller = controller;
	}

	KeyPad keyPad = new KeyPad();

	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(controller.MainScreen);
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
