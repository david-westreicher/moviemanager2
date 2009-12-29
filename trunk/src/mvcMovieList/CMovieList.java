package mvcMovieList;


import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import movie.Movie;
import mvcMovieComposite.CMovieComposite;
import mvcMovieComposite.GMovieCompositeSWT;
import mvcMovieManager.CMovieManager;
import mvcMovieManager.CMovieManagerSWT;
import mvcMovieManager.GMovieManagerSWT;

public abstract class CMovieList {

	protected static final int MAX_MOVIE_COMPOSITES = 100;
	protected MMovieList model;
	protected CMovieManager parent;

	public CMovieList(CMovieManager par) {
		this.parent = par;
		this.model = new MMovieList();
	}


	public void addMovie(Movie m) {
		List<Movie> result = model.addMovie(m);
		if (result == null) {
			add(m);
		} else if (result.size() == 0) {
		} else {
			draw(result);
		}
	}

	protected abstract void draw(List<Movie> result);

	public void initMovies(List<Movie> movies) {
		model.addMovies(movies);
		draw(movies);
	}

	public void search(String filterKey) {
		List<Movie> result = model.search(filterKey);
		if (!filterKey.equals(""))
			Collections.sort(result);
		draw(result);
	}

	public List<Movie> getMovies() {
		return model.getMovies();
	}


	private void add(Movie m) {
		if (model.movieNum < MAX_MOVIE_COMPOSITES) {
			addMovieComposite(m);
		} else {
			addSimpleComposite(m);
		}
		model.movieNum++;
		resize();
	}


	protected abstract void addSimpleComposite(Movie m);


	protected abstract void addMovieComposite(Movie m);


	protected abstract void resize();
}
