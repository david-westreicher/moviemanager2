package oldgui;

import java.util.List;

import org.eclipse.swt.SWT;

public class Appearance {

	public static final int TITLE_STYLE = SWT.BOLD;
	public static final String TITLE_FONT = "Verdana";
	public static final int HEIGHT = 15;

	public static String handleList(List<String> list) {
		StringBuffer sb = new StringBuffer();
		int i = 1;
		for (String s : list) {
			sb.append(s);
			if (i++ < list.size())
				sb.append(", ");
		}
		return sb.toString();
	}
}
