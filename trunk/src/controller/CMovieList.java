package controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

import oldgui.MovieComposite;

import gui.GMovieList;
import model.MMovieList;
import movie.Movie;

public class CMovieList {

	private GMovieList gui;
	private MMovieList model;

	public CMovieList(GMovieList gMovieList, MMovieList mMovieList) {
		this.gui = gMovieList;
		this.model = mMovieList;
	}

	public void addMovie(Movie m) {
		List<Movie> result = model.addMovie(m);
		if (result == null) {
			gui.add(m);
		} else
			gui.draw(result);
	}

	public void initMovies(List<Movie> movies) {
		if (movies != null) {
			model.addMovies(movies);
			gui.draw(movies);
		}
	}

	public void search(String filterKey) {
		List<Movie> result = model.search(filterKey);
		System.out.println("found " + result.size() + " movies");
		gui.draw(result);
	}

	public List<Movie> getMovies() {
		return model.getMovies();
	}

}
