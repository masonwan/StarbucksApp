package widgets;

import screens.*;
import commands.*;

public class AppController implements Screen, MenuBar {

	// Singleton pattern.

	private AppController() { // Prevent instantiation.
	}

	static AppController appController = new AppController();

	public static AppController getAppController() {
		return appController;
	}

	// Card management.

	private Card card = new Card();

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	// Command pattern

	private Command command;

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
	public void topLeftCmd() {
		screen.topLeftCmd();
	}

	@Override
	public void topRightCmd() {
		screen.topRightCmd();
	}

	// Implement MenuBar interface.

	@Override
	public void menuCards() {
		command = new CardMenuCommand();
		command.execute();
	}

	@Override
	public void menuPayments() {
		command = new PaymentMenuCommand();
		command.execute();
	}

	@Override
	public void menuRewards() {
		command = new RewardsMenuCommand();
		command.execute();
	}

	@Override
	public void menuStores() {
		command = new StoresMenuCommand();
		command.execute();
	}

	@Override
	public void menuSettings() {
		command = new SettingsMenuCommand();
		command.execute();
	}
}
