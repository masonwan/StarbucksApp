import java.util.ArrayList;

public class MainScreen implements Screen {
	Card card = new Card();
	ArrayList<Card> cards = new ArrayList<Card>();
	
	AppController controller;

	public MainScreen(AppController controller) {
		this.controller = controller;
		
		cards.add(new Card());
	}

	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(controller.PayScreen);
		} else if (x == 2 && y == 4) {
			controller.setScreen(controller.OptionsScreen);
		}
	}

	public String display() {
		return String.format("The balance is " + card.getBalance());
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}
}