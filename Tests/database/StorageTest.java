package database;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import movie.Movie;

import org.junit.Test;

import persistence.FileDB;
import system.IO;

public class StorageTest {

	@Test
	public void storageTest() {
		Movie m1 = new Movie();
		m1.setName("movie1");
		Movie m2 = new Movie();
		m2.setName("movie2");
		Movie m3 = new Movie();
		m3.setName("movie3");
		boolean succ = FileDB.store(new Movie[] { m1, m2, m3 });
		assertTrue(succ);
		List<Movie> movies = FileDB.getMovies();
		int i = 1;
		for (Movie m : movies) {
			assertEquals(m.getName(), "movie" + i++);
		}
	}
}
