package mvc;

import java.util.Observable;
import java.util.Observer;

public abstract class Controller implements Observer {
	protected Gui gui;
	protected Controller parent;
	protected Model model;

	public Controller(Gui gui, Model model, Controller parent) {
		this(gui,parent);
		this.model = model;
		model.addObserver(this);
	}

	private Controller(Gui gui, Controller parent) {
		this.parent = parent;
		this.gui = gui;
		addListeners();
	}

	@Override
	public void update(Observable o, Object arg) {
		modelChanged();
	}

	public void dispose() {
		model.deleteObserver(this);
		removeListeners();
	}

	protected abstract void addListeners();

	protected abstract void modelChanged();

	protected abstract void removeListeners();

}
