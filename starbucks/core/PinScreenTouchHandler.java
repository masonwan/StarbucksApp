package core;

import screens.*;

public class PinScreenTouchHandler extends HandlerBase {
	@Override
	protected void onHandle(Object sender, Object arg) {
		if (arg instanceof int[]) {
			int[] point = (int[]) arg;
			PinScreen screen = ((PinScreen) sender);
			screen.getState().handle(screen.getKeyPad().press(point[0], point[1]));
		}
	}
}
