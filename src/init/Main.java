package init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import movie.Movie;
import mvcMovieManager.CMovieManager;
import persistence.FileDB;
import system.Files;
import system.OS;

public class Main {

	private static CMovieManager controller;
	private static List<Movie> movies;
	private static ArrayList<String> toScan;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		settings();
		if (firstStart()) {
			folderStructure();
		} else {
			fastLoad();
		}
		// looping
		initGUI();
		// exit
		saveDB();
		exit();
	}

	private static void settings() {

	}

	private static void initGUI() {
		controller = new CMovieManager(movies, toScan);
	}

	private static void exit() {
		System.out.println("exiting MM");
		controller.stop();
	}

	private static void saveDB() {
		System.out.println("saving to DB");
		FileDB.store(controller.getMovies());
	}

	private static void fastLoad() {
		System.out.println("fast-loading the movies");
		movies = FileDB.getMovies();
		toScan = new ArrayList<String>(OS.getFolders(Files.MOVIE_FOLDER));
		for (Movie m : movies) {
			toScan.remove(new File(m.getFileLocation()).getName());
		}
	}

	private static void folderStructure() {
		System.out.println("slow-loading the movies");
		toScan = new ArrayList<String>(OS.getFolders(Files.MOVIE_FOLDER));
	}

	private static boolean firstStart() {
		System.out.println("Checking if MM was started before");
		return !OS.fileExists(Files.DATABASE_FILE);
	}

	private static void init() {
		System.out.println("Starting MM");
	}
}
