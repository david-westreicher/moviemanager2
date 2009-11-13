package controller;

import gui.GMovieList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
		Collections.sort(result);
		gui.draw(result);
	}

	public List<Movie> getMovies() {
		return model.getMovies();
	}

}
