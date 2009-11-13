package oldgui;

import java.util.ArrayList;
import java.util.List;

import movie.Movie;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;

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
public class MovieManager extends org.eclipse.swt.widgets.Composite {
	private ScrolledComposite sc;
	private Composite child;
	private Text text1;
	private List<Movie> movies;
	protected boolean typed;

	public static MovieManager INSTANCE = null;
	private static Shell shell;

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
		shell = new Shell(display, SWT.DIALOG_TRIM | SWT.MIN);
		MovieManager inst = new MovieManager(shell, SWT.NULL);
		INSTANCE = inst;
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

	public MovieManager(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		new Thread(new Runnable() {
			int movienum;

			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						if (typed || movies.size() != movienum) {
							Display.getDefault().syncExec(new Runnable() {
								public void run() {
									search(text1.getText());
								}
							});
							movienum = movies.size();
							typed = false;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		movies = new ArrayList<Movie>();
		initGUI();
	}

	private void initGUI() {
		try {
			setSize(MovieComposite.WIDTH, 500);
			RowLayout thisLayout = new RowLayout(org.eclipse.swt.SWT.VERTICAL);
			thisLayout.marginRight = 0;
			thisLayout.fill = true;
			this.setLayout(thisLayout);
			{
				RowData text1LData = new RowData();
				text1LData.width = 468;
				text1LData.height = 30;
				text1 = new Text(this, SWT.BORDER);
				FontData fontdata = new FontData("Verdana",20,SWT.BOLD);
				text1.setFont(new Font(Display.getDefault(),fontdata));
				text1.setLayoutData(text1LData);
				text1.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent arg0) {
						typed = true;
					}
				});
			}
			{
				sc = new ScrolledComposite(this, SWT.V_SCROLL);
				newChild();
				sc.setMinHeight(child.getSize().y);
				RowData scLData = new RowData();
				scLData.width = 477;
				scLData.height = 462;
				sc.setLayoutData(scLData);
				sc.setExpandHorizontal(true);
			}

			this.layout();
			// pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMovie(final Movie m) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				movies.add(m);
				showMovie(m);
				child.setSize(MovieComposite.WIDTH, MovieComposite.HEIGHT
						+ child.getSize().y);
				sc.setMinHeight(child.getSize().y);
			}
		});

	}

	public void showMovie(final Movie m) {
		new MovieComposite(child, SWT.PUSH | SWT.BORDER, m);
	}

	public void search(final String key) {
		newChild();
		final int num;
		synchronized (movies) {
			if (key.equals("")) {
				for (Movie m : movies) {
					showMovie(m);
				}
				num = movies.size();
			} else {
				int i = 0;
				for (Movie m : movies) {
					if (m.search(key)) {
						i++;
						showMovie(m);
					}
				}
				num = i;
			}
		}
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				child
						.setSize(MovieComposite.WIDTH, MovieComposite.HEIGHT
								* num);
				sc.setMinHeight(child.getSize().y);
			}
		});
	}

	private void newChild() {
		if (child != null)
			child.dispose();
		child = new Composite(sc, SWT.NONE);
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		child.setLayout(layout);
		child.setSize(MovieComposite.WIDTH, MovieComposite.HEIGHT);
		sc.setContent(child);
	}
}
