package screens;
public class PaymentsScreen extends ScreenBase {
	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 2) {
			controller.getCard().pay(1.5f);
		}
	}

	@Override
	public void display() {
		System.out.println("Enable Payments?");
	}
}
