public class AppController implements Screen, MenuBar {

	// State pattern
	PinScreen PinScreen;
	MainScreen MainScreen;
	PayScreen PayScreen;
	OptionsScreen OptionsScreen;
	MoreOptionsScreen MoreOptionsScreen;
	PaymentsScreen PaymentsScreen;
	RewardsScreen RewardsScreen;
	StoresScreen StoresScreen;
	SettingsScreen SettingsScreen;
	AddNewCardScreen AddNewCardScreen;
	private Screen screen;

	public Screen setScreen(Screen screen) {
		this.screen = screen;
		screen.display();

		return this.screen;
	}

	public Screen getScreen() {
		return screen;
	}

	// Singleton pattern
	static AppController appController = new AppController();

	private AppController() {
	}

	public static AppController getAppController() {
		return appController;
	}

	public void startUp() {
		PinScreen = new PinScreen(this);
		MainScreen = new MainScreen(this);
		PayScreen = new PayScreen(this);
		OptionsScreen = new OptionsScreen(this);
		MoreOptionsScreen = new MoreOptionsScreen(this);
		PaymentsScreen = new PaymentsScreen(this);
		RewardsScreen = new RewardsScreen(this);
		StoresScreen = new StoresScreen(this);
		SettingsScreen = new SettingsScreen(this);
		AddNewCardScreen = new AddNewCardScreen(this);
		setScreen(this.PinScreen);
	}

	// Screen
	public void touch(int x, int y) {
		screen.touch(x, y);
		System.out.println(screen.display());
	}

	public String display() {
		return screen.display();
	}

	public void topLeftCmd() {
		screen.topLeftCmd();
	}

	public void topRightCmd() {
		screen.topRightCmd();
	}

	// MenuBar public methods

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
