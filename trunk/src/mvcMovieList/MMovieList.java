package mvcMovieList;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import tools.GUIAccess;

import movie.Movie;

public class MMovieList {
	private List<Movie> allMovies;
	private String filterKey;
	public int movieNum;

	public MMovieList() {
		allMovies = new ArrayList<Movie>();
		filterKey = "";
	}

	public List<Movie> addMovie(Movie m) {
		if (!allMovies.contains(m)) {
			allMovies.add(m);
			if (filterKey.equals(""))
				return null;
			if (m.search(filterKey))
				return search(filterKey);
			else
				return new ArrayList<Movie>();
		}
		return null;
	}

	public List<Movie> search(String key) {
		this.filterKey = key;
		if (key.equals(""))
			return allMovies;
		else {
			List<Movie> result = new ArrayList<Movie>();
			for (Movie m : allMovies)
				if (m.search(key))
					result.add(m);
			return result;
		}
	}

	public void addMovies(List<Movie> movies) {
		this.allMovies = movies;
	}

	public List<Movie> getMovies() {
		return allMovies;
	}
}
