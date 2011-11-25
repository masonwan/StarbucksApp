package tests;

import static org.junit.Assert.*;

import org.junit.*;

import screens.*;
import states.*;
import widgets.*;

public class PinStateTest {

	private AppController controller = AppController.getAppController();
	private PinScreen screen;

	@Before
	public void setUp() throws Exception {
		controller.startUp();
	}

	private void reset() {
		screen = new PinScreen();
		controller.setScreen(screen);
	}

	@Test
	public void zeroPin() {
		System.out.println("\n==========Test zero pin");
		reset();

		controller.touch(1, 5); // 1
		controller.touch(3, 8); // X
		assertTrue(screen.getState() instanceof ZeroPin);
	}

	@Test
	public void onePin() {
		System.out.println("\n==========Test one pin");
		reset();

		screen.setState(new ZeroPin(screen));
		controller.touch(1, 5); // 1
		assertTrue(screen.getState() instanceof OnePin);

		screen.setState(new TwoPins(screen));
		controller.touch(3, 8); // X
		assertTrue(screen.getState() instanceof OnePin);
	}

	@Test
	public void twoPins() {
		System.out.println("\n==========Test two pins");
		reset();

		screen.setState(new OnePin(screen));
		controller.touch(3, 5); // 3
		assertTrue(screen.getState() instanceof TwoPins);

		screen.setState(new ThreePins(screen));
		controller.touch(3, 8); // X
		assertTrue(screen.getState() instanceof TwoPins);
	}

	@Test
	public void threePins() {
		System.out.println("\n==========Test three pins");
		reset();

		screen.setState(new TwoPins(screen));
		controller.touch(3, 7); // 9
		assertTrue(screen.getState() instanceof ThreePins);
	}

	@Test
	public void wrongPinAndReset() {
		System.out.println("\n==========Test wrong pin");
		reset();

		controller.touch(1, 5); // 1
		controller.touch(3, 5); // 3
		controller.touch(3, 7); // 9
		controller.touch(3, 8); // X
		controller.touch(2, 8); // 0
		controller.touch(1, 6); // 4
		assertTrue(controller.getScreen() instanceof PinScreen);
		assertTrue(screen.getState() instanceof ZeroPin);
	}

	// Correct pin is tested in ScreenTest.
}
