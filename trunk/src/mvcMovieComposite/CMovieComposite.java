package mvcMovieComposite;

import java.util.Observable;
import java.util.Observer;

import oldgui.Appearance;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import movie.Movie;
import mvcMovieList.CMovieList;
import mvcMovieList.CMovieListSWT;
import mvcMovieManager.CMovieManager;
import mvcMovieManager.CMovieManagerSwing;
import system.Files;
import system.IO;

public abstract class CMovieComposite implements Observer {

	protected MMovieComposite model;

	public CMovieComposite(CMovieManager parent) {
		this.model = new MMovieComposite();
	}

	public CMovieComposite(CMovieList parent, Movie m) {
		// TODO Auto-generated constructor stub
	}

	public void init() {
		model.addObserver(this);
	}

	protected abstract void setImg();

	@Override
	public void update(Observable o, Object arg) {
		// download complete
		setImg();
	}

}
