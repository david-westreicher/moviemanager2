package tools;

import org.eclipse.swt.widgets.Display;

public abstract class GUIAccess {

	public GUIAccess() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				execute();
			}
		});
	}

	protected abstract void execute();

}
