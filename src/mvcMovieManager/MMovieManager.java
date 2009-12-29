package mvcMovieManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Observable;

import parsing.MovieFactory;

import movie.Movie;
import system.Files;
import system.OS;
import tools.GUIAccess;
import tools.Stoppable;

public class MMovieManager extends Observable implements Stoppable {

	private Movie movie;
	private boolean running;
	private List<String> toScan;

	public MMovieManager(List<String> toScan2) {
		this.toScan = toScan2;
		running = true;
	}

	public void scan() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				for (String s : toScan) {
					try {
						if (running) {
							Movie m = new MovieFactory(Files.MOVIE_FOLDER
									+ OS.SEPARATOR + s).getMovie(s);
							if (running) {
								System.out.println(m);
								setMovie(m);
								setChanged();
								new GUIAccess() {
									@Override
									protected void execute() {
										notifyObservers();
									}
								};
							}
						}
					} catch (IOException e) {
						System.out
								.println("Error while processing '" + s + "'");
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	protected void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}

	public void stop() {
		running = false;
	}

}
