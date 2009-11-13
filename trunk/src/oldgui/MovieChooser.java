package oldgui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import movie.Movie;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;

import parsing.MovieFactory;


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
public class MovieChooser extends org.eclipse.swt.widgets.Composite implements
		MovieRightComposite {

	public static final String CHOOSED = "choosed";

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		showGUI();
	}

	private myObservable observable;
	private Movie movie;
	private ScrolledComposite sc;
	private Composite child;

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
		MovieChooser inst = new MovieChooser(shell, SWT.NULL);
		inst.setMovies(new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("www.google.at");
				add("www.google.at");
				add("www.google.at");
				add("www.google.at");
				add("www.google.at");
			}
		});
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

	public MovieChooser(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		this.observable = new myObservable();
		initGUI();
	}

	class myObservable extends Observable {
		public void updateHappened(Movie m) {
			movie = m;
			setChanged();
			notifyObservers(CHOOSED);
		}
	}

	public void addObserver(Observer o) {
		observable.addObserver(o);
	}

	public Movie getMovie() {
		return movie;
	}

	private void initGUI() {
		try {
			this.setLayout(new FillLayout());
			// this.setSize(MovieComposite.WIDTH, MovieComposite.HEIGHT);
			{
				sc = new ScrolledComposite(this, SWT.V_SCROLL);
				child = new Composite(sc, SWT.NONE);
				child.setLayout(new RowLayout(SWT.VERTICAL));
				sc.setContent(child);
				sc.setExpandVertical(true);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMovies(List<String> possibleSites) {
		for (final String s : possibleSites) {
			new MovieLink(child, SWT.PUSH, s).button2
					.addSelectionListener(new SelectionListener() {
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {
						}

						@Override
						public void widgetSelected(SelectionEvent arg0) {
							try {
								observable
										.updateHappened(new MovieFactory(null)
												.getMovie(new URL(s)));
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (URISyntaxException e) {
								e.printStackTrace();
							}
						}
					});
		}
		child.setSize(MovieComposite.WIDTH, MovieLink.HEIGHT
				* possibleSites.size());
		sc.setMinSize(MovieComposite.WIDTH, MovieLink.HEIGHT
				* possibleSites.size());
		// sc.setContent(child);
		// scrolledComposite1.setMinHeight(possibleSites.size()*MovieLink.HEIGHT);
		// scrolledComposite1.setContent(child);
	}

}
