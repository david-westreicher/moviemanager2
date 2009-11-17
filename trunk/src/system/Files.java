package system;

public class Files {
	public static final String DATA_FOLDER = ".mm";
	public static final String DOWNLOAD_FOLDER = System
			.getProperty("user.home")
			+ OS.SEPARATOR + DATA_FOLDER + OS.SEPARATOR;
	public static String MOVIE_FOLDER = "G:\\filme";

	private static final String FILE_NAME = "movies.mm";
	public static final String DATABASE_FOLDER = System
			.getProperty("user.home")
			+ OS.SEPARATOR + Files.DATA_FOLDER;
	public static final String DATABASE_FILE = DATABASE_FOLDER + OS.SEPARATOR
			+ FILE_NAME;
	public static final String NO_POSTER = "../ress/poster.jpg";

}
