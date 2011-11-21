public class MoreOptionsScreen implements Screen {

	AppController controller;

	public MoreOptionsScreen(AppController controller) {
		this.controller = controller;
	}

	@Override
	public void touch(int x, int y) {
	}

	@Override
	public String display() {
		return "Refresh, Reload or View Recent Transactions";
	}

	@Override
	public void topLeftCmd() {

	}

	@Override
	public void topRightCmd() {

	}
}
