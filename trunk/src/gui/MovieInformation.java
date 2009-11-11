package gui;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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
public class MovieInformation extends org.eclipse.swt.widgets.Composite
		implements MovieRightComposite {
	public Label label1;
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
		MovieInformation inst = new MovieInformation(shell, SWT.NULL);
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

	public MovieInformation(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(null);
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("label1");
				label1.setBounds(0, 0, 601, 22);
				FontData fd = new FontData(Appearance.TITLE_FONT, label1
						.getSize().y / 2, Appearance.TITLE_STYLE);
				label1.setFont(new Font(Display.getDefault(), fd));
			}
			{
				label2 = new Label(this, SWT.NONE);
				label2.setText("label2");
				label2.setBounds(0, 32, 601, 22);
			}
			{
				label3 = new Label(this, SWT.NONE);
				label3.setText("label3");
				label3.setBounds(0, 57, 601, 22);
			}
			{
				label4 = new Label(this, SWT.NONE);
				label4.setText("label4");
				label4.setBounds(0, 127, 601, 22);
			}
			this.layout();
			// pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
