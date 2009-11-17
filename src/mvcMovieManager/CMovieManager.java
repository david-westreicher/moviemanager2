package mvcMovieManager;

import init.Main;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;

import tools.Stoppable;
import movie.Movie;
import mvcMovieList.CMovieList;
import mvcMovieList.MMovieList;
import mvcSearchBar.CSearchBar;
import mvcSearchBar.MSearchBar;

public abstract class CMovieManager implements Stoppable, Observer {
	private MMovieManager model;
	protected CSearchBar searchBar;
	protected CMovieList movieList;

	public CMovieManager(List<Movie> movies, List<String> toScan) {
		this.model = new MMovieManager(toScan);
		model.addObserver(this);
		model.scan();
	}

	public void search(String filterKey) {
		movieList.search(filterKey);
	}

	public void stop() {
		searchBar.stop();
		model.stop();
		Main.saveDB();
		Main.exit();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// new movie
		movieList.addMovie(model.getMovie());
	}

	public List<Movie> getMovies() {
		return movieList.getMovies();
	}

	public abstract IGMovieManager getGUI();
}
