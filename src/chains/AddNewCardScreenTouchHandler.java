package chains;

import java.util.*;

import screens.*;

public class AddNewCardScreenTouchHandler extends HandlerBase {
	@Override
	protected void onHandle(Object sender, Object arg) {
		if (arg instanceof int[]) {
			int[] point = (int[]) arg;
			int x = point[0];
			int y = point[1];
			AddNewCardScreen screen = ((AddNewCardScreen) sender);
			ArrayList<Character> id = screen.getId();
			ArrayList<Character> pinCode = screen.getPinCode();

			if (x >= 1 && x <= 3 && y == 3) {
				screen.setFocus(Focus.Id);
			} else if (x == 2 && y == 4) {
				screen.setFocus(Focus.Pin);
			} else if (x >= 1 && x <= 3 && y >= 5 && y <= 8) {
				char pressedKey = screen.getKeyPad().press(x, y);

				if (screen.getFocus() == Focus.Id) {
					if (id.size() == 16) {
						return;
					}

					id.add(pressedKey);

					if (id.size() == 16) {
						screen.setFocus(Focus.Pin);
					}
				} else if (screen.getFocus() == Focus.Pin) {
					if (pinCode.size() == 4) {
						return;
					}

					pinCode.add(pressedKey);
				}
			}

			screen.display();
		}
	}
}
