package persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import system.Files;
import system.OS;

import movie.Movie;

public class FileDB {

	public static List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			ObjectInputStream objstream = new ObjectInputStream(
					new FileInputStream(Files.DATABASE_FILE));
			int length = objstream.readInt();
			for (int i = 0; i < length; i++)
				movies.add((Movie) objstream.readObject());
			objstream.close();
			return movies;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean store(Movie[] movies) {
		if (!OS.fileExists(Files.DATABASE_FOLDER)) {
			OS.makeFolder(Files.DATABASE_FOLDER);
		}
		if (!OS.fileExists(Files.DATABASE_FILE)) {
			OS.makeFile(Files.DATABASE_FILE);
		} else
			OS.clearFile(Files.DATABASE_FILE);
		try {
			ObjectOutputStream objstream = new ObjectOutputStream(
					new FileOutputStream(Files.DATABASE_FILE));
			objstream.writeInt(movies.length);
			for (int i = 0; i < movies.length; i++)
				objstream.writeObject(movies[i]);
			objstream.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean store(List<Movie> movies) {
		return store(movies.toArray(new Movie[0]));
	}
}
