package movie;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OS {

	static void start(String fileLocation) {
		String[] command = new String[4];
		command[0] = "cmd";
		command[1] = "/C";
		command[2] = "start";
		command[3] = '"' + fileLocation + '"';
		//fileLocation = fileLocation.replace(" ", "&20");
		String cmd = "cmd /C explorer " +  '"'+ fileLocation+ '"' ;
		try {
			Process p = Runtime.getRuntime().exec(cmd);
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
}
