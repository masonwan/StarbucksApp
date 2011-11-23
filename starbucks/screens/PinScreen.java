package screens;

import adapters.*;
import chains.*;
import states.*;

import java.util.ArrayList;

import observers.Observer;
import observers.Subject;
import states.PinState;
import widgets.*;

public class PinScreen extends ScreenBase implements Subject {

	// Key management.

	// private int keyIndex = 0;
	// private char[] keys = new char[4];
	private Pin pin = new Pin("1234".toCharArray());

	public Pin getPin() {
		return pin;
	}

	public int getNumKeys() {
		return pin.getKeys().length;
	}

	private KeyPadAdapter keyPad = new KeyPadAdapter();

	public KeyPadAdapter getKeyPad() {
		return keyPad;
	}

	private PasscodeDisplay passcodeDisplay;
	private Handler handler;

	public PinScreen() {
		setState(new ZeroPin(this));

		attach(passcodeDisplay = new PasscodeDisplay());

		handler = new PinScreenTouchHandler();
		handler.setNext(new PinScreenDisplayHandler());
	}

	// Implement Screen

	@Override
	public void touch(int x, int y) {
		handler.handle(this, new int[] { x, y });
		// state.handle(keyPad.press(x, y));
	}

	@Override
	public void display() {
		handler.handle(this, null);
	}

	// PinState pattern.

	private PinState state;

	public PinState setState(PinState state) {
		this.state = state;
		inform();

		return this.state;
	}

	public PinState getState() {
		return state;
	}

	// Implement Subject interface.
	// Observer pattern.

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * Attach an observer.
	 */
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	/**
	 * Detach an observer.
	 */
	@Override
	public boolean detach(Observer o) {
		return observers.remove(o);
	}

	/**
	 * Inform the observers to update their data.
	 */
	@Override
	public void inform() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
