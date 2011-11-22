package core;

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

//	PinScreen PinScreen;
//	MainScreen MainScreen;
//	PayScreen PayScreen;
//	OptionsScreen OptionsScreen;
//	MoreOptionsScreen MoreOptionsScreen;
//	PaymentsScreen PaymentsScreen;
//	RewardsScreen RewardsScreen;
//	StoresScreen StoresScreen;
//	SettingsScreen SettingsScreen;
//	AddNewCardScreen AddNewCardScreen;
	private Screen screen;

	public Screen setScreen(Screen screen) {
		this.screen = screen;
		screen.display();

		return this.screen;
	}

	public Screen getScreen() {
		return screen;
	}

	public void startUp() {
//		PinScreen = new PinScreen(this);
//		MainScreen = new MainScreen(this);
//		PayScreen = new PayScreen(this);
//		OptionsScreen = new OptionsScreen(this);
//		MoreOptionsScreen = new MoreOptionsScreen(this);
//		PaymentsScreen = new PaymentsScreen(this);
//		RewardsScreen = new RewardsScreen(this);
//		StoresScreen = new StoresScreen(this);
//		SettingsScreen = new SettingsScreen(this);
//		AddNewCardScreen = new AddNewCardScreen(this);
		setScreen(new PinScreen());
	}

	// Implement Screen interface.

	@Override
	public void touch(int x, int y) {
		screen.touch(x, y);
		screen.display(); // Automatically trigger display for every action.
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
