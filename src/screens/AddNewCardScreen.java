package screens;

import java.util.*;

import widgets.*;
import adapters.*;
import chains.*;

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
		handler.handle(this, new int[] { x, y });
	}

	@Override
	public void display() {
		System.out.println(String.format("Enter a new card:\nID: %s Code: %s", id.toString(), pinCode.toString()));
	}

	@Override
	public void topLeftCommand() {
		controller.setScreen(new SettingsScreen());
	}

	@Override
	public void topRightCommand() {
		char[] idTemp = new char[16];

		for (int i = 0; i < id.size(); i++) {
			idTemp[i] = id.get(i);
		}

		char[] pinCodeTemp = new char[4];

		for (int i = 0; i < pinCode.size(); i++) {
			pinCodeTemp[i] = pinCode.get(i);
		}

		controller.setCard(new Card(idTemp, new Pin(pinCodeTemp)));
		controller.setScreen(new MainScreen());
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