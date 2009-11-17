package mvcMovieComposite;

import movie.Movie;
import mvcMovieList.CMovieListSWT;

import oldgui.Appearance;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import system.Files;
import system.IO;

public class CMovieCompositeSWT extends CMovieComposite implements
		MouseListener {
	private GMovieCompositeSWT gui;

	public CMovieCompositeSWT(CMovieListSWT parent, Movie m) {
		super(parent, m);
		this.gui = new GMovieCompositeSWT(parent.getGUI().composite1, SWT.BORDER | SWT.PUSH);
		super.init();
		init2();
	}

	private void init2() {
		GridData composite1LData = new GridData();
		composite1LData.horizontalAlignment = GridData.FILL;
		composite1LData.verticalAlignment = GridData.BEGINNING;
		composite1LData.grabExcessHorizontalSpace = true;
		gui.setLayoutData(composite1LData);
		gui.label1.addMouseListener(this);
		if (model.coverLoaded()) {
			setImg();
		} else
			gui.label1.setImage(new Image(Display.getDefault(), IO
					.getImage(Files.NO_POSTER)));
		Movie movie = model.getMovie();
		gui.movieInformation1.label1.setText(movie.getName());
		gui.movieInformation1.label2.setText(Appearance.handleList(movie
				.getDirector()));
		gui.movieInformation1.label3.setText(Appearance.handleList(movie
				.getActors()));
		if (movie.getRuntime() != null)
			gui.movieInformation1.label4.setText(movie.getRuntime());
		gui.movieInformation1.progressBar1.setSelection((int) (movie
				.getRating() * 10));
	}

	protected void setImg() {
		if (!gui.isDisposed())
			gui.label1
					.setImage(new Image(Display.getDefault(), model.getImg()));
	}

	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		model.play();
	}

	@Override
	public void mouseUp(MouseEvent arg0) {
	}

}
