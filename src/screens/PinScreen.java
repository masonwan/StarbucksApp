package screens;

import java.util.*;

import observers.*;
import observers.Observer;
import states.*;
import widgets.*;
import adapters.*;
import chains.*;

public class PinScreen extends ScreenBase implements Subject {

	// Key management.

	private Pin pin = new Pin("1234".toCharArray());

	public Pin getPin() {
		return pin;
	}

	private KeyPadAdapter keyPad = new KeyPadAdapter();

	public KeyPadAdapter getKeyPad() {
		return keyPad;
	}

	// Chain of responsibility pattern.

	private Handler handler;

	public Handler getHanlder() {
		return handler;
	}

	public PinScreen() {
		setState(new ZeroPin(this));

		attach(new PasscodeDisplay());

		handler = new PinScreenTouchHandler();
		handler.setNext(new PinScreenDisplayHandler());
	}

	// Implement Screen

	@Override
	public void touch(int x, int y) {
		handler.handle(this, new int[] { x, y });
	}

	@Override
	public void display() {
		handler.handle(this, null);
	}

	// State pattern.

	private State state;

	public State setState(State state) {
		this.state = state;
		inform();

		return this.state;
	}

	public State getState() {
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
