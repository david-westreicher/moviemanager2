package mvcSearchBar;

import mvcMovieManager.CMovieManager;
import mvcMovieManager.CMovieManagerSWT;

import oldgui.Appearance;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class CSearchBarSWT extends CSearchBar implements ModifyListener {

	private Text gui;

	public CSearchBarSWT(CMovieManagerSWT parent) {
		super(parent);
		this.gui = new Text(parent.getGUI().composite1, SWT.NONE);
		init();
	}

	private void init() {
		Font f = new Font(Display.getDefault(), new FontData(
				Appearance.TITLE_FONT, 30, SWT.BOLD));
		gui.setFont(f);
		gui.setText(model.getFilterKey());
		gui.addModifyListener(this);
	}

	@Override
	public void modifyText(ModifyEvent arg0) {
		model.filterKeyChanged(gui.getText());
	}

}
