package widgets;

import observers.Observer;
import screens.*;

public class PasscodeDisplay implements Observer {

	@Override
	public void update(Object sender) {
		PinScreen screen = ((PinScreen) sender);
		int numKeys = screen.getNumKeys();

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < numKeys; i++) {
			builder.append('*');
		}

		System.out.println(builder.toString());
	}
}
