package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Observable;

import parsing.MovieFactory;

import movie.Movie;
import system.Files;
import system.IO;
import system.OS;
import tools.GUIAccess;
import tools.Stoppable;

public class MMovieManager extends Observable implements Stoppable {

	private Movie movie;
	private boolean running;
	private ArrayList<String> toScan;

	public MMovieManager(ArrayList<String> toScan) {
		this.toScan = toScan;
		running = true;
	}

	public void scan() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (String s : toScan) {
					try {
						if (running) {
							Movie m = new MovieFactory(Files.MOVIE_FOLDER
									+ OS.SEPARATOR + s).getMovie(s);
							if (running) {
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
