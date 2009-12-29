package tools;

import org.eclipse.swt.widgets.Display;

import system.Settings;
import javax.swing.SwingUtilities;

public abstract class GUIAccess {

	public GUIAccess() {
		if (Settings.CURRENT_STYLE == Settings.GuiStyle.SWT)
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					execute();
				}
			});
		else if (Settings.CURRENT_STYLE == Settings.GuiStyle.SWING) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					execute();
				}
			});
		}
	}

	protected abstract void execute();

}
