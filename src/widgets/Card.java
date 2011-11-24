package widgets;

public class Card {

	private Pin pin;

	public Pin getPin() {
		return pin;
	}

	private char[] id;

	public char[] getId() {
		return id;
	}

	public static final Card empty = new Card(new char[0], new Pin(new char[0]));

	public Card(char[] id, Pin pin) {
		this.id = id;
		this.pin = pin;
	}

	private float balance = 16.50f;

	public double getBalance() {
		return balance;
	}

	public boolean pay(float amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}

		return false;
	}
}
