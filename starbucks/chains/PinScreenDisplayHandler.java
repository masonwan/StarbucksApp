package chains;

import screens.*;

public class PinScreenDisplayHandler extends HandlerBase {
	@Override
	protected void onHandle(Object sender, Object arg) {
		// Actually, PasscodeDisplay has been observing the change of PinScreen. What this doing is just a duplicate. Comment it.
		
		if (arg == null) {
			PinScreen screen = ((PinScreen) sender);
			int numKeys = screen.getNumKeys();

			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < numKeys; i++) {
				builder.append('*');
			}

			// System.out.println(builder.toString());
		}
	}
}
