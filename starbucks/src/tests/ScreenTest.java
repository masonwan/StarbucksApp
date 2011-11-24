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
