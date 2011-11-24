package screens;

public class MainScreen extends ScreenBase {
	@Override
	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(new PayScreen());
		} else if (x == 2 && y == 4) {
			controller.setScreen(new OptionsScreen());
		}
	}

	@Override
	public void display() {
		System.out.println(String.format("The balance is " + controller.getCard().getBalance()));
	}
}