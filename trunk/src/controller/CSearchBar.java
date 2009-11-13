package controller;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

import tools.Stoppable;

import gui.GSearchBar;
import model.MSearchBar;

public class CSearchBar implements ModifyListener, Observer, Stoppable {

	private GSearchBar gui;
	private MSearchBar model;
	private MMController parent;

	public CSearchBar(GSearchBar gSearchBar, MSearchBar mSearchBar, MMController mmController) {
		this.gui = gSearchBar;
		this.model = mSearchBar;
		this.parent = mmController;
		init();
	}

	private void init() {
		gui.text1.setText(model.getFilterKey());
		gui.text1.addModifyListener(this);
		model.addObserver(this);
	}

	@Override
	public void modifyText(ModifyEvent arg0) {
		model.filterKeyChanged(gui.text1.getText());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// key has changed, tell main application
		parent.search(model.getFilterKey());
	}

	public void stop() {
		model.stop();
	}

}
