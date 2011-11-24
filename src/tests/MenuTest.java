package tests;

import static org.junit.Assert.*;

import org.junit.*;

import screens.*;
import widgets.*;

public class MenuTest {

	private AppController controller = AppController.getAppController();

	@Before
	public void setUp() throws Exception {
		controller.startUp();
	}

	@Test
	public void pressMenuInPinScreen() {
		System.out.println("\n==========Test pressing menu in PinScreen.");
		controller.setScreen(new PinScreen());

		controller.menuCards();
		assertTrue(controller.getScreen() instanceof PinScreen);
		controller.menuPayments();
		assertTrue(controller.getScreen() instanceof PinScreen);
		controller.menuRewards();
		assertTrue(controller.getScreen() instanceof PinScreen);
		controller.menuStores();
		assertTrue(controller.getScreen() instanceof PinScreen);
		controller.menuSettings();
		assertTrue(controller.getScreen() instanceof PinScreen);
	}

	@Test
	public void menuCards() {
		controller.setScreen(new MainScreen());
		controller.menuCards();
		assertTrue(controller.getScreen() instanceof MainScreen);
	}

	@Test
	public void menuPayments() {
		controller.setScreen(new MainScreen());
		controller.menuPayments();
		assertTrue(controller.getScreen() instanceof PaymentsScreen);
	}

	@Test
	public void menuRewards() {
		controller.setScreen(new MainScreen());
		controller.menuRewards();
		assertTrue(controller.getScreen() instanceof RewardsScreen);
	}

	@Test
	public void menuStores() {
		controller.setScreen(new MainScreen());
		controller.menuStores();
		assertTrue(controller.getScreen() instanceof StoresScreen);
	}

	@Test
	public void menuSettings() {
		controller.setScreen(new MainScreen());
		controller.menuSettings();
		assertTrue(controller.getScreen() instanceof SettingsScreen);
	}
}
