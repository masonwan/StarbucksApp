public class StoresScreen implements Screen {

	AppController controller;

	public StoresScreen(AppController controller) {
		this.controller = controller;
	}

	@Override
	public void touch(int x, int y) {
	}

	@Override
	public String display() {
		return "Google Map of Local Starbucks";
	}

	@Override
	public void topLeftCmd() {
	}

	@Override
	public void topRightCmd() {
	}
}
