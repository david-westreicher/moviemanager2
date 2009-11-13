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

import tools.Stoppable;

import mvcMovieManager.CMovieManager;

public class CSearchBar implements ModifyListener, Observer, Stoppable {

	private Text gui;
	private MSearchBar model;
	private CMovieManager parent;

	public CSearchBar(Composite parent, MSearchBar mSearchBar,
			CMovieManager mmController) {
		this.gui = new Text(parent,SWT.NONE);
		this.model = mSearchBar;
		this.parent = mmController;
		init();
	}

	private void init() {
		Font f = new Font(Display.getDefault(), new FontData(Appearance.TITLE_FONT,30,SWT.BOLD));
		gui.setFont(f);
		gui.setText(model.getFilterKey());
		gui.addModifyListener(this);
		model.addObserver(this);
	}

	@Override
	public void modifyText(ModifyEvent arg0) {
		model.filterKeyChanged(gui.getText());
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
