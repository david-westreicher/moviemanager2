package init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import movie.Movie;
import mvcMovieManager.CMovieManager;
import mvcMovieManager.CMovieManagerSWT;
import mvcMovieManager.CMovieManagerSwing;
import persistence.FileDB;
import system.Files;
import system.OS;
import system.Settings;

public class Main {

	private static CMovieManager controller;
	private static List<Movie> movies;
	private static List<String> toScan;

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
		// looping if SWT
		initGUI();
		if (Settings.CURRENT_STYLE == Settings.GuiStyle.SWT) {
			// exit
			saveDB();
			exit();
		}
	}

	private static void settings() {
		Settings.CURRENT_STYLE = Settings.GuiStyle.SWING;
	}

	private static void initGUI() {
		if (Settings.CURRENT_STYLE == Settings.GuiStyle.SWT)
			controller = new CMovieManagerSWT(movies, toScan);
		else if (Settings.CURRENT_STYLE == Settings.GuiStyle.SWING)
			controller = new CMovieManagerSwing(movies, toScan);
	}

	public static void exit() {
		System.out.println("exiting MM");
		if (Settings.CURRENT_STYLE == Settings.GuiStyle.SWT)
			controller.stop();
	}

	public static void saveDB() {
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
		toScan = OS.getFolders(Files.MOVIE_FOLDER);
		System.out.println(toScan);
	}

	private static boolean firstStart() {
		System.out.println("Checking if MM was started before");
		return !OS.fileExists(Files.DATABASE_FILE);
	}

	private static void init() {
		System.out.println("Starting MM");
		if (!OS.fileExists(Files.DOWNLOAD_FOLDER)) {
			OS.makeFolder(Files.DOWNLOAD_FOLDER);
		}
	}
}
