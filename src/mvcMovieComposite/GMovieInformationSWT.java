package mvcMovieComposite;


import oldgui.Appearance;
import oldgui.MovieRightComposite;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GMovieInformationSWT extends org.eclipse.swt.widgets.Composite
		implements MovieRightComposite {
	public Label label1;
	public Button button1;
	public ProgressBar progressBar1;
	public Label label4;
	public Label label3;
	public Label label2;

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
	 */
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		GMovieInformationSWT inst = new GMovieInformationSWT(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			// inst.pack();
			// shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public GMovieInformationSWT(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			thisLayout.numColumns = 2;
			this.setLayout(thisLayout);
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("label1");
				GridData label1LData = new GridData();
				label1LData.horizontalAlignment = GridData.FILL;
				label1LData.grabExcessHorizontalSpace = true;
				label1LData.verticalAlignment = GridData.BEGINNING;
				label1LData.horizontalSpan = 2;
				label1.setLayoutData(label1LData);
				FontData fd = new FontData(Appearance.TITLE_FONT, 11, Appearance.TITLE_STYLE);
				label1.setFont(new Font(Display.getDefault(), fd));
			}
			{
				label2 = new Label(this, SWT.NONE);
				label2.setText("label2");
				FontData d = new FontData();
				d.setHeight(8);
				label2.setFont(new Font(Display.getDefault(),d));
				GridData label2LData = new GridData();
				label2LData.verticalAlignment = GridData.BEGINNING;
				label2LData.grabExcessHorizontalSpace = true;
				label2LData.horizontalAlignment = GridData.FILL;
				label2LData.horizontalSpan = 2;
				label2.setLayoutData(label2LData);
			}
			{
				label3 = new Label(this, SWT.WRAP);
				label3.setText("label3");
				GridData label3LData = new GridData();
				label3LData.verticalAlignment = GridData.FILL;
				label3LData.horizontalAlignment = GridData.FILL;
				label3LData.grabExcessHorizontalSpace = true;
				label3LData.horizontalSpan = 2;
				label3.setLayoutData(label3LData);
			}
			{
				progressBar1 = new ProgressBar(this, SWT.SMOOTH);
				progressBar1.setMaximum(100);
				progressBar1.setMinimum(0);
				GridData progressBar1LData = new GridData();
				progressBar1LData.verticalAlignment = GridData.END;
				progressBar1LData.horizontalAlignment = GridData.FILL;
				progressBar1LData.grabExcessHorizontalSpace = true;
				progressBar1LData.horizontalSpan = 2;
				progressBar1.setLayoutData(progressBar1LData);
			}
			{
				label4 = new Label(this, SWT.NONE);
				label4.setText("label4");
				GridData label4LData = new GridData();
				label4LData.horizontalAlignment = GridData.FILL;
				label4LData.grabExcessHorizontalSpace = true;
				label4LData.verticalAlignment = GridData.END;
				label4.setLayoutData(label4LData);
			}
			{
				button1 = new Button(this, SWT.PUSH | SWT.CENTER);
				button1.setText("IMDB");
				GridData button1LData = new GridData();
				button1LData.verticalAlignment = GridData.END;
				button1LData.horizontalAlignment = GridData.END;
				button1.setLayoutData(button1LData);
			}
			this.layout();
			// pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
