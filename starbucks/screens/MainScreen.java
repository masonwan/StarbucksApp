package screens;

import core.*;

import java.util.ArrayList;

public class MainScreen extends ScreenBase {
	Card card = new Card();
	ArrayList<Card> cards = new ArrayList<Card>();

	public MainScreen() {
		cards.add(new Card());
	}

	@Override
	public void touch(int x, int y) {
		if (x == 3 && y == 3) {
			controller.setScreen(new PayScreen());
		} else if (x == 2 && y == 4) {
			controller.setScreen(new OptionsScreen());
		}
	}

	@Override
	public void display() {
		System.out.println(String.format("The balance is " + card.getBalance()));
	}
}