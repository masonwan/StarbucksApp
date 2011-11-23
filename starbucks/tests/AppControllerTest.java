package tests;

import static org.junit.Assert.*;
import screens.*;
import widgets.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppControllerTest {

	private AppController app;

	public AppControllerTest() {
	}

	@Before
	public void setUp() {
		app = AppController.getAppController();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void wrongPinAndReset() {
		System.out.println("\n==========Test wrong pin");
		app.startUp();
		app.touch(1, 5); // 1
		app.touch(3, 5); // 3
		app.touch(3, 7); // 9
		app.touch(3, 8); // X
		app.touch(2, 8); // 0
		app.touch(1, 6); // 4
		assertTrue(app.getScreen() instanceof PinScreen);
		assertTrue(((PinScreen) app.getScreen()).getNumKeys() == 0);
	}

	@Test
	public void pinToMain() {
		System.out.println("\n==========Test valid pin");
		goMain();
		assertTrue(app.getScreen() instanceof MainScreen);
	}

	void goMain() {
		app.startUp();
		app.touch(1, 5); // 1
		app.touch(2, 5); // 2
		app.touch(3, 5); // 3
		app.touch(1, 6); // 4
	}

	@Test
	public void mainToPay() {
		System.out.println("\n==========Test go pay screen");
		goMain();
		app.getScreen().touch(3, 3);
		assertTrue(app.getScreen() instanceof PayScreen);
	}

	@Test
	public void payToMain() {
		System.out.println("\n==========Test go back to main screen");
		goMain();
		app.getScreen().touch(3, 3);
		app.getScreen().touch(3, 3);
		assertTrue(app.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToOptions() {
		System.out.println("\n==========Test go option screen");
		goOptions();
		assertTrue(app.getScreen() instanceof OptionsScreen);
	}

	void goOptions() {
		goMain();
		app.getScreen().touch(2, 4);
	}

	@Test
	public void optionsToMoreOptions() {
		System.out.println("\n==========Test go more option screen");

		goOptions();
		app.getScreen().touch(1, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);

		goOptions();
		app.getScreen().touch(2, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);

		goOptions();
		app.getScreen().touch(3, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);
	}
}
