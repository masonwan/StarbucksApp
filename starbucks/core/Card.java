package core;

public class Card {

	float balance = 16.50f;
	Pin pin = new Pin(new char[4]);

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
