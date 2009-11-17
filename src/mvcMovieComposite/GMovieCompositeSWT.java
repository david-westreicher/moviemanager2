package mvcMovieComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

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
public class GMovieCompositeSWT extends org.eclipse.swt.widgets.Composite {
	public Label label1;
	public GMovieInformationSWT movieInformation1;

	/**
	 * Overriding checkSubclass allows this class to extend
	 * org.eclipse.swt.widgets.Composite
	 */
	protected void checkSubclass() {
	}

	public GMovieCompositeSWT(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.numColumns = 2;
			this.setLayout(thisLayout);
			{
				label1 = new Label(this, SWT.NONE);
				GridData label1LData = new GridData();
				label1LData.widthHint = 94;
				label1LData.heightHint = 140;
				label1LData.verticalAlignment = GridData.BEGINNING;
				label1.setLayoutData(label1LData);
				label1.setText("label1");
			}
			{
				GridData movieInformation1LData = new GridData();
				movieInformation1LData.horizontalAlignment = GridData.FILL;
				movieInformation1LData.grabExcessHorizontalSpace = true;
				movieInformation1LData.verticalAlignment = GridData.FILL;
				movieInformation1 = new GMovieInformationSWT(this, SWT.NONE);
				movieInformation1.setLayoutData(movieInformation1LData);
			}

			this.layout();
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
