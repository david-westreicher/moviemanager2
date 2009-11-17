package mvcMovieList;

import java.util.List;
import mvcMovieComposite.GMovieCompositeSWT;

import movie.Movie;
import oldgui.MovieComposite;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
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
public class GMovieListSWT extends org.eclipse.swt.widgets.Composite {
	public Composite composite1;
	public int movieNum;
	public ScrolledComposite sc;

	/**
	 * Overriding checkSubclass allows this class to extend
	 * org.eclipse.swt.widgets.Composite
	 */
	protected void checkSubclass() {
	}

	public GMovieListSWT(Composite parent) {
		this(parent, SWT.NONE);
	}

	public GMovieListSWT(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			FillLayout thisLayout = new FillLayout(
					org.eclipse.swt.SWT.HORIZONTAL);
			this.setLayout(thisLayout);
			{
				sc = new ScrolledComposite(this, SWT.V_SCROLL);
				sc.setExpandHorizontal(false);
				sc.setExpandVertical(false);
				sc.setLayout(new FillLayout());
				composite1 = new Composite(sc, SWT.NONE);
				composite1.setSize(sc.getSize().x-20,sc.getSize().y);
				//composite1.setSize(sc.getSize().x - 20, composite1.computeSize(
				//		SWT.DEFAULT, SWT.DEFAULT).y);
				GridLayout rl = new GridLayout();
				rl.makeColumnsEqualWidth = true;
				rl.numColumns = 1;
				composite1.setLayout(rl);
				sc.setContent(composite1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
