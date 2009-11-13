package oldgui;

import java.util.Observable;
import java.util.Observer;

import movie.Movie;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import system.IO;

import com.cloudgarden.resource.SWTResourceManager;

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
public class MovieComposite extends org.eclipse.swt.widgets.Composite implements
		Observer {

	public static final int HEIGHT = 165;
	private MovieRightComposite mr;
	public static final int WIDTH = 500;

	{
		// Register as a resource user - SWTResourceManager will
		// handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Label label1;
	private static Display display;
	private Movie m;
	private MovieChooser mc;

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setName("Title");
		movie.setFileLocation("G:\\filme\\21 Gramm");
		movie.addDirector("Quentin Tarantino");
		movie.addDirector("Stanley Kubrick");
		movie.addActor("Actor Actress");
		movie.addActor("Actor Actress");
		movie.addActor("Actor Actress");
		movie.addActor("Actor Actress");
		movie.addActor("Actor Actress");
		movie.addActor("Actor Actress");
		movie.addActor("Actor Actress");
		movie.setRuntime("64 min");
		movie.setDecided(false);
		movie.addPossibleSite("/tt1298826/");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		movie.addPossibleSite("test");
		showGUI(movie);
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
	public static void showGUI(Movie mov) {
		display = Display.getDefault();
		Shell shell = new Shell(display);
		MovieComposite inst = new MovieComposite(shell, SWT.NULL | SWT.BORDER,
				mov);
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

	public MovieComposite(org.eclipse.swt.widgets.Composite parent, int style,
			Movie m) {
		super(parent, style);
		init(m);
	}

	private void initMovie(final Movie m) {
		this.m = m;
		if (m.isDecided()) {
			m.addObserver(this);
			MovieInformation mi = (MovieInformation) mr;
			mi.label1.setText(m.getName());
			mi.label2.setText(Appearance.handleList(m.getDirector())+", and written by "+Appearance.handleList(m.getWriter()));
			mi.label3.setText(Appearance.handleList(m.getActors()));
			if (m.getRuntime() != null)
				mi.label4.setText(m.getRuntime());
			mi.progressBar1.setSelection((int)(m.getRating()*10));
			m.loadImg();
		} else {
			final MovieChooser mc = (MovieChooser) mr;
			mc.addObserver(this);
			mc.setMovies(m.getPossibleSites());
		}
	}

	public void dispose() {
		m.deleteObserver(this);
		super.dispose();
	}

	private void initGUI(Movie movie) {
		try {
			this.setLayout(null);
			{
				label1 = new Label(this, SWT.NONE);
				label1.setBounds(12, 12, 96, 141);
				if (movie.getCoverLocal() == null)
					label1.setImage(new Image(display, IO.class
							.getResourceAsStream("../res/poster.jpg")));
				else
					label1.setImage(new Image(display, movie.getCoverLocal()));
				label1.addMouseListener(new MouseListener() {
					@Override
					public void mouseDoubleClick(MouseEvent arg0) {
					}

					@Override
					public void mouseDown(MouseEvent arg0) {
						m.play();
					}

					@Override
					public void mouseUp(MouseEvent arg0) {
					}
				});
			}
			{
				if (movie.isDecided()) {
					if (mc != null)
						mc.dispose();
					mr = new MovieInformation(this, SWT.NONE);
				} else {
					mc = new MovieChooser(this, SWT.BORDER);
					mc.setSize(368, 141);
					mr = mc;
				}
				mr.setBounds(120, 12, 355, 141);
			}
			this.layout();
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 == null) {
			// download complete
			//Display.getDefault().syncExec(new Runnable() {
			//	public void run() {
			//		if (!label1.isDisposed())
						label1.setImage(new Image(display, m.getCoverLocal()));
			//	}
			//});
		} else {
			init(mc.getMovie());
		}
	}

	private void init(Movie movie) {
		initGUI(movie);
		initMovie(movie);
	}

}
