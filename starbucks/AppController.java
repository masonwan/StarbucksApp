public class AppController implements Screen, MenuBar {
	
	// Card management.
	
	private Card card = new Card();
	
	public Card getCard(){
		return card;
	}
	
	public void setCard(Card card){
		this.card = card;
	}

	// State pattern.

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

	// Singleton pattern.

	private AppController() { // Prevent instantiation.
	}

	static AppController appController = new AppController();

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

	// Implement Screen interface.

	@Override
	public void touch(int x, int y) {
		screen.touch(x, y);
		System.out.println(screen.display());
	}

	@Override
	public String display() {
		return screen.display();
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
		command = new CardMenuCommand(this);
		command.execute();
	}

	@Override
	public void menuPayments() {
		command = new PaymentMenuCommand(this);
		command.execute();
	}

	@Override
	public void menuRewards() {
		command = new RewardsMenuCommand(this);
		command.execute();
	}

	@Override
	public void menuStores() {
		command = new StoresMenuCommand(this);
		command.execute();
	}

	@Override
	public void menuSettings() {
		command = new SettingsMenuCommand(this);
		command.execute();
	}

	// Command pattern

	Command command;

	interface Command {
		void execute();
	}

	class CardMenuCommand implements Command {
		AppController controller;

		public CardMenuCommand(AppController controller) {
			this.controller = controller;
		}

		@Override
		public void execute() {
			if (screen instanceof PinScreen)
				return;
			controller.setScreen(controller.MainScreen);
		}
	}

	class PaymentMenuCommand implements Command {
		AppController controller;

		public PaymentMenuCommand(AppController controller) {
			this.controller = controller;
		}

		@Override
		public void execute() {
			if (controller.getScreen() instanceof PinScreen)
				return;
			controller.setScreen(controller.PaymentsScreen);
		}
	}

	class RewardsMenuCommand implements Command {
		AppController controller;

		public RewardsMenuCommand(AppController controller) {
			this.controller = controller;
		}

		@Override
		public void execute() {
			if (controller.getScreen() instanceof PinScreen)
				return;
			controller.setScreen(controller.RewardsScreen);
		}
	}

	class StoresMenuCommand implements Command {
		AppController controller;

		public StoresMenuCommand(AppController controller) {
			this.controller = controller;
		}

		@Override
		public void execute() {
			if (controller.getScreen() instanceof PinScreen)
				return;
			controller.setScreen(controller.StoresScreen);
		}
	}

	class SettingsMenuCommand implements Command {
		AppController controller;

		public SettingsMenuCommand(AppController controller) {
			this.controller = controller;
		}

		@Override
		public void execute() {
			if (controller.getScreen() instanceof PinScreen)
				return;
			controller.setScreen(controller.SettingsScreen);
		}
	}
}
