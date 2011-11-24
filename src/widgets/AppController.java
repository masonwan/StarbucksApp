package widgets;

import screens.PinScreen;
import screens.Screen;

import commands.CardMenuCommand;
import commands.MenuInvoker;
import commands.PaymentMenuCommand;
import commands.RewardsMenuCommand;
import commands.SettingsMenuCommand;
import commands.StoresMenuCommand;

public class AppController implements Screen, MenuBar {

	// Singleton pattern.

	private AppController() { // Prevent instantiation.
	}

	private static AppController controller;

	public static AppController getAppController() {
		if (controller == null) {
			controller = new AppController();
		}

		return controller;
	}

	// Card management.

	private Card card = Card.empty;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	// State pattern.

	private Screen screen;

	public Screen setScreen(Screen screen) {
		Screen oldScreen = this.screen;
		this.screen = screen;

		String oldScreenName = (oldScreen == null) ? "null" : oldScreen.getClass().getSimpleName();
		String newscreenName = this.screen.getClass().getSimpleName();

		if (oldScreenName == newscreenName) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(String.format("The screen was changed from %s to %s", oldScreenName, newscreenName));

		screen.display();

		return this.screen;
	}

	public Screen getScreen() {
		return screen;
	}

	public void startUp() {
		setScreen(new PinScreen());
	}

	// Implement Screen interface.

	@Override
	public void touch(int x, int y) {
		screen.touch(x, y);
	}

	@Override
	public void display() {
		screen.display();
	}

	@Override
	public void topLeftCommand() {
		screen.topLeftCommand();
	}

	@Override
	public void topRightCommand() {
		screen.topRightCommand();
	}

	// Implement MenuBar interface.
	// Command pattern.

	MenuInvoker menuInvoker = new MenuInvoker();

	@Override
	public void menuCards() {
		menuInvoker.setCommand(new CardMenuCommand());
		menuInvoker.execute();
	}

	@Override
	public void menuPayments() {
		menuInvoker.setCommand(new PaymentMenuCommand());
		menuInvoker.execute();
	}

	@Override
	public void menuRewards() {
		menuInvoker.setCommand(new RewardsMenuCommand());
		menuInvoker.execute();
	}

	@Override
	public void menuStores() {
		menuInvoker.setCommand(new StoresMenuCommand());
		menuInvoker.execute();
	}

	@Override
	public void menuSettings() {
		menuInvoker.setCommand(new SettingsMenuCommand());
		menuInvoker.execute();
	}
}
