package tests;

import static org.junit.Assert.*;

import org.junit.*;

import screens.*;
import widgets.*;

public class ScreenTest {

	private AppController controller = AppController.getAppController();

	@Before
	public void setUp() throws Exception {
		controller.startUp();
	}

	@Test
	public void pinToMain() {
		System.out.println("\n==========Test valid pin");
		touchCorrectPin();
		assertTrue(controller.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToPay() {
		System.out.println("\n==========Test go pay screen");
		touchCorrectPin();
		controller.getScreen().touch(3, 3);
		assertTrue(controller.getScreen() instanceof PayScreen);
	}

	@Test
	public void payToMain() {
		System.out.println("\n==========Test go back to main screen");
		touchCorrectPin();
		controller.getScreen().touch(3, 3);
		controller.getScreen().touch(3, 3);
		assertTrue(controller.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToOptions() {
		System.out.println("\n==========Test go option screen");
		touchToGoPayScreen();
		assertTrue(controller.getScreen() instanceof OptionsScreen);
	}

	@Test
	public void optionsToMoreOptions() {
		System.out.println("\n==========Test go more option screen");

		touchToGoPayScreen();
		controller.getScreen().touch(1, 7);
		assertTrue(controller.getScreen() instanceof MoreOptionsScreen);

		touchToGoPayScreen();
		controller.getScreen().touch(2, 7);
		assertTrue(controller.getScreen() instanceof MoreOptionsScreen);

		touchToGoPayScreen();
		controller.getScreen().touch(3, 7);
		assertTrue(controller.getScreen() instanceof MoreOptionsScreen);
	}

	@Test
	public void addNewCard() {
		System.out.println("\n==========Test adding new card");

		touchCorrectPin();
		controller.menuSettings();
		controller.touch(1, 2);

		// Focus pin.
		controller.touch(2, 4);

		// Type pin.
		controller.touch(3, 6); // 6
		controller.touch(1, 7); // 7
		controller.touch(2, 7); // 8
		controller.touch(3, 7); // 9

		// Focus id.
		controller.touch(1, 3);

		// Type id.
		controller.touch(1, 5); // 1
		controller.touch(2, 5); // 2
		controller.touch(3, 5); // 3
		controller.touch(1, 6); // 4
		controller.touch(2, 6); // 5
		controller.touch(3, 6); // 6
		controller.touch(1, 7); // 7
		controller.touch(2, 7); // 8
		controller.touch(3, 7); // 9
		controller.touch(2, 8); // 0
		controller.touch(1, 5); // 1
		controller.touch(2, 5); // 2
		controller.touch(3, 5); // 3
		controller.touch(1, 6); // 4
		controller.touch(2, 6); // 5
		controller.touch(3, 6); // 6

		controller.topRightCommand();
		Card card = controller.getCard();
		Pin pin = card.getPin();
		pin.setKeys("6789".toCharArray());

		assertTrue(pin.validate());

		char[] idTested = card.getId();
		char[] idSample = "1234567890123456".toCharArray();

		for (int i = 0; i < idSample.length; i++) {
			if (idTested[i] != idSample[i]) {
				fail("The card id is different.");
			}
		}
	}

	void touchCorrectPin() {
		controller.startUp();
		controller.touch(1, 5); // 1
		controller.touch(2, 5); // 2
		controller.touch(3, 5); // 3
		controller.touch(1, 6); // 4
	}

	void touchToGoPayScreen() {
		touchCorrectPin();
		controller.getScreen().touch(2, 4);
	}
}
