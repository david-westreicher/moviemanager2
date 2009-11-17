package mvcMovieManager;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GMovieManagerSWT extends org.eclipse.swt.widgets.Composite implements IGMovieManager{

	private static Display display;
	private static Shell shell;
	public static Composite composite2;
	public static Composite composite1;
	private static GMovieManagerSWT instance;

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		showGUI();
	}

	/**
	 * Overriding checkSubclass allows this class to extend
	 * org.eclipse.swt.widgets.Composite
	 */
	protected void checkSubclass() {
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite
	 * inside a new Shell.
	 * 
	 * @return
	 */
	public static GMovieManagerSWT showGUI() {
		display = Display.getDefault();
		shell = new Shell(display);
		instance = new GMovieManagerSWT(shell, SWT.NONE);
		Point size = instance.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			// instance.pack();
			// shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		return instance;
	}

	public static void show() {
		//composite1.pack();
		composite1.layout();
		composite2.layout();
		instance.layout();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public GMovieManagerSWT(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() { 
		try {
			this.setSize(500,500);
			GridLayout thisLayout = new GridLayout();
			thisLayout.makeColumnsEqualWidth = true;
			this.setLayout(thisLayout);
			{
				composite1 = new Composite(this, SWT.NONE);
				FillLayout composite1Layout = new FillLayout(org.eclipse.swt.SWT.HORIZONTAL);
				composite1.setLayout(composite1Layout);
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.verticalAlignment = GridData.BEGINNING;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				//composite1.setBounds(0, 0, 500, 64);
			}
			{
				composite2 = new Composite(this, SWT.NONE);
				FillLayout composite2Layout = new FillLayout(org.eclipse.swt.SWT.HORIZONTAL);
				composite2.setLayout(composite2Layout);
				GridData composite2LData = new GridData();
				composite2LData.horizontalAlignment = GridData.FILL;
				composite2LData.grabExcessHorizontalSpace = true;
				composite2LData.verticalAlignment = GridData.FILL;
				composite2LData.grabExcessVerticalSpace = true;
				composite2.setLayoutData(composite2LData);
			}
			//pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
