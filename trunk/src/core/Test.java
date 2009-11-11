package core;

import gui.MovieComposite;
import gui.MovieManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.swt.widgets.Display;

import movie.IO;
import movie.Movie;

public class Test {

	private static final boolean SIMPLE_TEST = false;

	/**
	 * @param args
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException,
			URISyntaxException, InterruptedException {
		// IMDB imdb = new IMDB("dazed+and+confused");
		// new IMDBSearch("falling down");
		if (SIMPLE_TEST) {
			Movie m = new MovieFactory(null).getMovie("2001");
			System.out.println(m);
			System.out.println(m.search("2001"));
		} else {
			new Thread(new Runnable() {

				@Override
				public void run() {
					MovieManager.showGUI();
				}
			}).start();
			Thread.sleep(2000);
			final MovieManager mm = MovieManager.INSTANCE;
			String[] command = new String[5];
			command[0] = "cmd";
			command[1] = "/C";
			command[2] = "dir";
			command[3] = IO.MOVIE_FOLDER;
			command[4] = "/B";
			Process p;
			try {
				p = Runtime.getRuntime().exec(command);

				BufferedReader stdInput = new BufferedReader(
						new InputStreamReader(p.getInputStream()));

				String s = null;
				while ((s = stdInput.readLine()) != null) {
					try {

						Movie m = new MovieFactory(s).getMovie(s);
						System.out.println(m);
						mm.addMovie(m);
					} catch (IOException e) {
						System.out
								.println("Error while processing '" + s + "'");
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
