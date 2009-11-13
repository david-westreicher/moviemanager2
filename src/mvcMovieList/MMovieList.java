package mvcMovieList;

import java.util.ArrayList;
import java.util.List;

import movie.Movie;

public class MMovieList {
	private List<Movie> allMovies;
	private String filterKey;

	public MMovieList() {
		allMovies = new ArrayList<Movie>();
		filterKey = "";
	}

	public List<Movie> addMovie(Movie m) {
		if (!allMovies.contains(m)) {
			allMovies.add(m);
			if (filterKey.equals(""))
				return null;
			return search(filterKey);
		}
		return null;
	}

	public List<Movie> search(String key) {
		System.out.println("searching for " + key);
		this.filterKey = key;
		if (key.equals(""))
			return allMovies;
		else {
			long start = System.currentTimeMillis();
			List<Movie> result = new ArrayList<Movie>();
			for (Movie m : allMovies)
				if (m.search(key))
					result.add(m);
			System.out.println("searched in "
					+ (System.currentTimeMillis() - start));
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
