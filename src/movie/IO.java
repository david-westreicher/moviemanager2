package movie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IO {
	public static String MOVIE_FOLDER = "G:\\filme";

	public static StringBuffer downloadText(String strURL) throws IOException {
		URLConnection urlc = new URL(strURL).openConnection();
		urlc.addRequestProperty("user-agent", "Firefox");
		InputStream stream = urlc.getInputStream();
		StringBuffer data = new StringBuffer();
		int buffer;
		while ((buffer = stream.read()) != -1) {
			data.append((char) buffer);
		}
		stream.close();
		return data;
	}

	public static String downloadToFile(String strURL, String toFile)
			throws MalformedURLException, IOException {
		String dest = "C://mm/" + toFile;
		InputStream in = new URL(strURL).openStream();
		FileOutputStream out = new FileOutputStream(dest);
		byte[] buf = new byte[4 * 1024];
		int bytesRead;
		while ((bytesRead = in.read(buf)) != -1) {
			out.write(buf, 0, bytesRead);
		}
		out.close();
		in.close();
		return dest;
	}

}