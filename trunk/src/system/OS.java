package system;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class OS {

	public static final String SEPARATOR = System.getProperty("file.separator");

	public static void start(String fileLocation) {
		String[] command = new String[4];
		command[0] = "cmd";
		command[1] = "/C";
		command[2] = "start";
		command[3] = '"' + fileLocation + '"';
		String cmd = "cmd /C explorer " + '"' + fileLocation + '"';
		System.out.println(cmd);
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void browse(String url) {
		Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI(url));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static boolean fileExists(String fileLocation) {
		File file = new File(fileLocation);
		return file.exists();
	}

	public static void makeFolder(String folder) {
		new File(folder).mkdirs();
	}

	public static void makeFile(String file) {
		File f = new File(file);
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static void clearFile(String file) {
		File f = new File(file);
		f.delete();
		makeFile(file);
	}

	public static List<String> getFolders(String folder) {
		ArrayList<String> folders = new ArrayList<String>();
		try {
			Process p = Runtime.getRuntime().exec(
					new String[] { "cmd", "/C", "dir", Files.MOVIE_FOLDER, "/B" });
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				folders.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return folders;
	}
}
