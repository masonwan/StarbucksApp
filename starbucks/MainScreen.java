import java.util.ArrayList;

public class MainScreen implements AppScreen {
	Card card = new Card();
	ArrayList<Card> cards = new ArrayList<Card>();

	public MainScreen() {
		cards.add(new Card());
	}

	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			// Go to PayScreen.
		} else if (x == 2 && y == 4) {
			// Go to OptionScreen.
		}
	}

	public String display() {
		// Show the balance of current card.
		StringBuilder builder = new StringBuilder();

		builder.append(card.getBalance());

		return String.format("The balance is %1$", card.getBalance());
	}

	public void topLeftCmd() {

	}

	public void topRightCmd() {

	}
}