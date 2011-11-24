package screens;

public class OptionsScreen extends ScreenBase {
	@Override
	public void touch(int x, int y) {
		if (x >= 1 && x <= 3 && y == 7) {
			controller.setScreen(new MoreOptionsScreen());
		}
	}

	@Override
	public void display() {
		System.out.println("Reload, Refresh Balance, or More options");
	}
}
