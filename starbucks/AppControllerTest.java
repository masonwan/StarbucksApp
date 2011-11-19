import static org.junit.Assert.*;
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
	public void pinToMain() {
		app.setScreen(app.PinScreen);
		app.touch(1, 5);
		app.touch(2, 5);
		app.touch(3, 5);
		app.touch(1, 6);
		assertTrue(app.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToPay() {
		app.setScreen(app.MainScreen);
		app.getScreen().touch(3, 3);
		assertTrue(app.getScreen() instanceof PayScreen);
	}

	@Test
	public void payToMain() {
		app.setScreen(app.PayScreen);
		app.getScreen().touch(3, 3);
		assertTrue(app.getScreen() instanceof MainScreen);
	}

	@Test
	public void mainToOptions() {
		app.setScreen(app.MainScreen);
		app.getScreen().touch(2, 4);
		assertTrue(app.getScreen() instanceof OptionsScreen);
	}

	@Test
	public void optionsToMoreOptions() {

		app.setScreen(app.OptionsScreen);
		app.getScreen().touch(1, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);

		app.setScreen(app.OptionsScreen);
		app.getScreen().touch(2, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);

		app.setScreen(app.OptionsScreen);
		app.getScreen().touch(3, 7);
		assertTrue(app.getScreen() instanceof MoreOptionsScreen);
	}
}
