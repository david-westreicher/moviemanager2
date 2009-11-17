package mvcMovieComposite;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.graphics.Rectangle;

import movie.Movie;
import tools.GUIAccess;

public class MMovieComposite extends Observable implements Observer {
	private Movie movie;

	public MMovieComposite(final Movie m) {
		this.movie = m;
		movie.addObserver(this);
	}
	
	public void downloadImg(){
		movie.loadImg();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//download complete
		new GUIAccess() {
			@Override
			protected void execute() {
				setChanged();
				notifyObservers();
			}
		};
	}

	public String getImg() {
		return movie.getCoverLocal();
	}

	public boolean coverLoaded() {
		return movie.getCoverLocal()!=null;
	}

	public void play() {
		movie.play();
	}

	public String getName() {
		return movie.getName();
	}

	public Movie getMovie() {
		return movie;
	}
}
