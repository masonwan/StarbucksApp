package core;
public abstract class HandlerBase implements Handler {
	protected Handler nextHandler;

	@Override
	public final void handle(Object sender, Object arg) {
		onHandle(sender, arg);

		if (nextHandler != null) {
			nextHandler.handle(sender, arg);
		}
	}

	protected abstract void onHandle(Object sender, Object arg);

	@Override
	public Handler setNext(Handler handler) {
		return nextHandler = handler;
	}
}
