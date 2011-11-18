public class AppController implements AppScreen, IMenuBar {
	// State pattern

	public final PinScreen PinScreen = new PinScreen();
	public final MainScreen MainScreen = new MainScreen();
	public final PayScreen PayScreen = new PayScreen();
	public final OptionsScreen OptionsScreen = new OptionsScreen();
	public final MoreOptionsScreen MoreOptionsScreen = new MoreOptionsScreen();
	public final PaymentsScreen PaymentsScreen = new PaymentsScreen();
	public final RewardsScreen RewardsScreen = new RewardsScreen();
	public final StoresScreen StoresScreen = new StoresScreen();
	public final SettingsScreen SettingsScreen = new SettingsScreen();
	public final AddNewCardScreen AddNewCardScreen = new AddNewCardScreen();

	AppScreen screen;

	public void setScreen(AppScreen screen) {
		this.screen = screen;
		this.screen.display();
	}

	// Singleton pattern

	static AppController appController = new AppController();

	private AppController() {

	}

	public AppController getAppController() {
		return appController;
	}

	public void startUp() {
		setScreen(this.PinScreen);
	}

	public String onScreen() {
		return screen.display();
	}

	// AppScreen

	public void touch(int x, int y) {
		screen.touch(x, y);
	}

	public String display() {
		return screen.display();
	}

	public void topLeftCmd() {
		screen.display();
	}

	public void topRightCmd() {
		screen.display();
	}

	// IMenubar public methods

	public void menuCards() {
		if (screen instanceof PinScreen)
			return;

		setScreen(this.MainScreen);
	}

	public void menuPayments() {
		if (screen instanceof PinScreen)
			return;

		setScreen(this.PaymentsScreen);
	}

	public void menuRewards() {
		if (screen instanceof PinScreen)
			return;

		setScreen(this.RewardsScreen);
	}

	public void menuStores() {
		if (screen instanceof PinScreen)
			return;

		setScreen(this.StoresScreen);
	}

	public void menuSettings() {
		if (screen instanceof PinScreen)
			return;

		setScreen(this.SettingsScreen);
	}
}
