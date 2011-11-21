public class PaymentsScreen implements Screen {

	AppController controller;

	public PaymentsScreen(AppController controller) {
		this.controller = controller;
	}

	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 2) {
			controller.getCard().pay(1.5f);
		}
	}

	@Override
	public String display() {
		return "Enable Payments?";
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}
}
