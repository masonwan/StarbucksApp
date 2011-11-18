public class OptionsScreen implements AppScreen {

	public void touch(int x, int y) {
		if (y == 7) {
			// Go to MoreOptionsScreen.
		}
	}

	public String display() {
		return "Reload, Refresh Balance, or More options";
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}
}
