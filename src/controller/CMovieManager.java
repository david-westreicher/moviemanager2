package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import tools.Stoppable;
import model.MMovieManager;
import model.MMovieList;
import model.MSearchBar;
import movie.Movie;
import gui.GMovieList;
import gui.GMovieManager;

public class CMovieManager implements Stoppable, Observer {
	public static final int MMHeight = 800;
	public static final int MMWidth = 500;

	private GMovieManager gui;
	private MMovieManager model;
	private CSearchBar searchBar;
	private CMovieList movieList;

	public CMovieManager(List<Movie> movies, ArrayList<String> toScan) {
		this.gui = GMovieManager.showGUI();
		this.model = new MMovieManager(toScan);
		this.searchBar = new CSearchBar(GMovieManager.composite1,
				new MSearchBar(), this);
		this.movieList = new CMovieList(new GMovieList(
				GMovieManager.composite2, SWT.NONE), new MMovieList());
		model.addObserver(this);
		model.scan();
		gui.layout();
		movieList.initMovies(movies);
		GMovieManager.show();
	}

	public void search(String filterKey) {
		movieList.search(filterKey);
	}

	public void stop() {
		searchBar.stop();
		model.stop();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// new movie
		movieList.addMovie(model.getMovie());
	}

	public List<Movie> getMovies() {
		return movieList.getMovies();
	}

}
