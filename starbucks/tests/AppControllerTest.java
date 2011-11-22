package tests;

import static org.junit.Assert.*;
import core.*;
import screens.*;

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
		app.startUp();
	}

	@After
	public void tearDown() {
	}

	// Screen workflow.

	@Test
	public void wrongPinAndReset() {
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
		app.startUp();
		app.touch(1, 5); // 1
		app.touch(2, 5); // 2
		app.touch(3, 5); // 3
		app.touch(1, 6); // 4
		assertTrue(app.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToPay() {
		pinToMain();
		app.getScreen().touch(3, 3);
		assertTrue(app.getScreen() instanceof PayScreen);
	}

	@Test
	public void payToMain() {
		mainToPay();
		app.getScreen().touch(3, 3);
		assertTrue(app.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToOptions() {
		pinToMain();
		app.getScreen().touch(2, 4);
		assertTrue(app.getScreen() instanceof OptionsScreen);
	}

	@Test
	public void optionsToMoreOptions() {

		mainToOptions();
		app.getScreen().touch(1, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);

		mainToOptions();
		app.getScreen().touch(2, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);

		mainToOptions();
		app.getScreen().touch(3, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);
	}
}
