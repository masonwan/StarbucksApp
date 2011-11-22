package screens;

import core.*;

public abstract class ScreenBase implements Screen {
	protected final AppController controller;

	public ScreenBase() {
		controller = AppController.getAppController();
	}

	@Override
	public void touch(int x, int y) {

	}

	@Override
	public void topLeftCmd() {
	}

	@Override
	public void topRightCmd() {
	}
}