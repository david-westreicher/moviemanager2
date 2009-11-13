package tools;

public abstract class StoppableRunnable implements Runnable, Stoppable {

	private boolean running = true;

	public void run() {
		while (running) {
			execute();
		}
	}

	public abstract void execute();

	public void stop() {
		running = false;
	}
}
