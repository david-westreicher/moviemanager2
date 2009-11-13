package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;

import tools.Stoppable;
import model.MMModel;
import model.MMovieList;
import model.MSearchBar;
import movie.Movie;
import gui.GMovieList;
import gui.GSearchBar;
import gui.MMGui;

public class MMController implements Stoppable, Observer {
	public static final int MMHeight = 800;
	public static final int MMWidth = 500;

	private MMGui gui;
	private MMModel model;
	private CSearchBar searchBar;
	private CMovieList movieList;

	public MMController(List<Movie> movies, ArrayList<String> toScan) {
		this.gui = MMGui.showGUI();
		this.model = new MMModel(toScan);
		GSearchBar gsb = new GSearchBar(gui,SWT.PUSH);
		this.searchBar = new CSearchBar(gsb, new MSearchBar(), this);
		GMovieList gml = new GMovieList(gui,SWT.PUSH);
		this.movieList = new CMovieList(gml, new MMovieList());
		model.addObserver(this);
		model.scan();

		movieList.initMovies(movies);
		MMGui.show();
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
		System.out.println("adding " + model.getMovie());
		movieList.addMovie(model.getMovie());
	}

	public List<Movie> getMovies() {
		return movieList.getMovies();
	}

}
