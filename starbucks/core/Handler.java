package core;
public interface Handler {
	void handle(Object sender, Object arg);

	Handler setNext(Handler handler);
}