package observers;

public interface Subject {
	public void attach(Observer o);

	public boolean detach(Observer o);

	public void inform();
}
