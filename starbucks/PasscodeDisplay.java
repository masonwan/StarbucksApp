public class PasscodeDisplay implements Observer {

	@Override
	public void update(Object sender, Object arg) {
		System.out.println(((PinScreen)sender).display());
	}
}
