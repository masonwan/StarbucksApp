package chains;

import screens.*;

public class PinScreenDisplayHandler extends HandlerBase {
	@Override
	protected void onHandle(Object sender, Object arg) {
		if (arg == null) {
			PinScreen screen = ((PinScreen) sender);
			int numKeys = screen.getPin().getKeys().length;

			if (numKeys == 0) {
				System.out.println("Enter pin to unlock.");
			} else {
				StringBuilder builder = new StringBuilder("Your pin is ");

				for (int i = 0; i < numKeys; i++) {
					builder.append('*');
				}

				System.out.println(builder.toString());
			}
		}
	}
}
