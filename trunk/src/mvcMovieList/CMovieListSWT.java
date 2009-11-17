package mvcMovieList;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import movie.Movie;
import mvcMovieComposite.CMovieComposite;
import mvcMovieComposite.CMovieCompositeSWT;
import mvcMovieManager.CMovieManagerSWT;

public class CMovieListSWT extends CMovieList implements ControlListener {

	private GMovieListSWT gui;

	public CMovieListSWT(CMovieManagerSWT par) {
		super(par);
		this.gui = new GMovieListSWT(par.getGUI().composite2);
		init();
	}

	private void init() {
		gui.sc.addControlListener(this);
	}

	@Override
	public void controlMoved(ControlEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controlResized(ControlEvent arg0) {
		resize();
	}
	

	private void resetMovieContainer() {
		Control[] child = gui.composite1.getChildren();
		for (Control c : child)
			c.dispose();
	}

	private void redraw() {
		gui.composite1.layout();
		gui.composite1.redraw();
	}

	public void draw(List<Movie> movies) {
		resetMovieContainer();
		model.movieNum = movies.size();
		if (movies.size() > MAX_MOVIE_COMPOSITES) {
			for (Movie m : movies) {
				addSimpleComposite(m);
			}
		} else {
			for (Movie m : movies) {
				addMovieComposite(m);
			}
		}
		resize();
		redraw();
	}

	protected void addSimpleComposite(Movie m) {
		GridData composite1LData = new GridData();
		composite1LData.horizontalAlignment = GridData.FILL;
		composite1LData.verticalAlignment = GridData.BEGINNING;
		composite1LData.grabExcessHorizontalSpace = true;
		Label l = new Label(gui.composite1, SWT.BORDER | SWT.PUSH);
		l.setLayoutData(composite1LData);
		l.setText(m.getName());
	}

	protected void resize() {
		gui.composite1.setSize(gui.sc.getSize().x - 20, gui.composite1
				.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
	}

	protected void addMovieComposite(Movie m) {
		new CMovieCompositeSWT(this, m);
	}

	public GMovieListSWT getGUI() {
		return gui;
	}

}
