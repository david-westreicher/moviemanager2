package mvcSearchBar;

import java.util.Observable;
import java.util.Observer;

import oldgui.Appearance;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import tools.GUIAccess;
import tools.Stoppable;

import mvcMovieManager.CMovieManager;

public abstract class CSearchBar implements Observer, Stoppable {
	protected MSearchBar model;
	private CMovieManager parent;

	public CSearchBar(CMovieManager mmController) {
		this.model = new MSearchBar();
		this.parent = mmController;
		init();
	}

	private void init() {
		model.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// key has changed, tell main application
		new GUIAccess() {
			@Override
			protected void execute() {
				parent.search(model.getFilterKey());
			}
		};
	}

	public void stop() {
		model.stop();
	}

}
