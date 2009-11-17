package mvcMovieManager;

import java.util.List;

import movie.Movie;
import mvcMovieList.CMovieList;
import mvcMovieList.CMovieListSWT;
import mvcMovieList.MMovieList;
import mvcSearchBar.CSearchBar;
import mvcSearchBar.CSearchBarSWT;
import mvcSearchBar.MSearchBar;

public class CMovieManagerSWT extends CMovieManager {
	private GMovieManagerSWT gui;

	public CMovieManagerSWT(List<Movie> movies, List<String> toScan) {
		super(movies, toScan);
		this.gui = GMovieManagerSWT.showGUI();
		searchBar = new CSearchBarSWT(this);
		movieList = new CMovieListSWT(this);
		gui.layout();
		movieList.initMovies(movies);
		GMovieManagerSWT.show();
	}

	@Override
	public GMovieManagerSWT getGUI() {
		return gui;
	}

}
