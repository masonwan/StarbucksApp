package screens;

import java.util.ArrayList;

import widgets.Card;
import widgets.Pin;
import adapters.KeyPadAdapter;
import chains.AddNewCardScreenTouchHandler;
import chains.Handler;

public class AddNewCardScreen extends ScreenBase {

	private KeyPadAdapter keyPad = new KeyPadAdapter();

	public KeyPadAdapter getKeyPad() {
		return keyPad;
	}

	// Chain of responsibility pattern.

	Handler handler;

	public AddNewCardScreen() {
		handler = new AddNewCardScreenTouchHandler();
	}

	// Implement Screen

	@Override
	public void touch(int x, int y) {
		handler.handle(this, null);
	}

	@Override
	public void display() {
		System.out.println(String.format("Enter a new card:\nID: %d Code: %d", id.toString(), pinCode.toString()));
	}

	@Override
	public void topLeftCmd() {
		controller.setScreen(new SettingsScreen());
	}

	@Override
	public void topRightCmd() {
		char[] idTemp = new char[16];

		for (int i = 0; i < id.size(); i++) {
			idTemp[i] = id.get(i);
		}

		char[] pinCodeTemp = new char[4];

		for (int i = 0; i < pinCode.size(); i++) {
			pinCodeTemp[i] = pinCode.get(i);
		}

		controller.setCard(new Card(idTemp, new Pin(pinCodeTemp)));
		controller.setScreen(new PinScreen());
	}

	// Focus management.

	private Focus focus = Focus.Id;

	public void setFocus(Focus focus) {
		this.focus = focus;
	}

	public Focus getFocus() {
		return focus;
	}

	private ArrayList<Character> id = new ArrayList<Character>(16);

	public ArrayList<Character> getId() {
		return id;
	}

	private ArrayList<Character> pinCode = new ArrayList<Character>(4);

	public ArrayList<Character> getPinCode() {
		return pinCode;
	}
}