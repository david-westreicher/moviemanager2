package mvcMovieList;

import java.util.List;

import movie.Movie;
import oldgui.MovieComposite;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
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
public class GMovieList extends org.eclipse.swt.widgets.Composite {
	private final static int HEIGHT = 300;
	private Composite composite1;
	private int childHeight;

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
		GMovieList inst = new GMovieList(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
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

	public GMovieList(Composite parent) {
		this(parent, SWT.NONE);
	}

	public GMovieList(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			FillLayout thisLayout = new FillLayout(
					org.eclipse.swt.SWT.HORIZONTAL);
			this.setLayout(thisLayout);
			setSize(MovieComposite.WIDTH, HEIGHT);
			{
				ScrolledComposite sc = new ScrolledComposite(this, SWT.V_SCROLL);
				sc.setMinSize(MovieComposite.WIDTH, 500);
				sc.setExpandHorizontal(false);
				sc.setExpandVertical(false);
				composite1 = new Composite(sc, SWT.NONE);
				RowLayout rl = new RowLayout(SWT.VERTICAL);
				rl.fill = true;
				composite1.setLayout(rl);
				// composite1.layout(true);
				sc.setContent(composite1);
			}
			// this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Composite getMovieContainer() {
		return composite1;
	}

	private void resetMovieContainer() {
		Control[] child = composite1.getChildren();
		for (Control c : child)
			c.dispose();
	}

	private void draw() {
		composite1.layout();
		composite1.redraw();
	}

	public void draw(List<Movie> movies) {
		resetMovieContainer();
		if (movies.size() > 50) {
			childHeight = movies.size() *21;
			for (Movie m : movies) {
				addSimpleComposite(m);
			}
		} else {
			childHeight = movies.size() * MovieComposite.HEIGHT;
			for (Movie m : movies) {
				addMovieComposite(m);
			}
		}
		resize();
		draw();
	}

	private void addSimpleComposite(Movie m) {
		Label l = new Label(composite1, SWT.BORDER | SWT.PUSH);
		l.setText(m.getName());
	}

	private void resize() {
		composite1.setSize(MovieComposite.WIDTH, childHeight);
	}

	private void addMovieComposite(Movie m) {
		new MovieComposite(composite1, SWT.BORDER | SWT.PUSH, m);
	}

	public void add(Movie m) {
		childHeight += MovieComposite.HEIGHT;
		addMovieComposite(m);
		resize();
	}

}
