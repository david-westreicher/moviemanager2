package parsing;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;

import org.htmlparser.Node;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.Translate;

import system.Files;
import system.IO;
import system.OS;

public class MovieFactory {
	public enum Search {
		KEY, URL
	};

	private static final String IMDB_SEARCH = "http://www.imdb.com/Title?";
	private static final boolean LOGGING = false;
	private String site;
	private Movie m;
	private long startTime;

	public MovieFactory(String file) {
		this.m = new Movie();
		m.setFileLocation(file);
	}

	public Movie getMovie(URL url) throws URISyntaxException, IOException {
		System.out.println("browsing to: " + url.toURI().toString());
		m.setImdbURL(url.toURI().toString());
		startTimer();
		this.site = getData(url).toString().replaceAll("\\s\\s+|\\n|\\r", "");
		site = site.replaceAll("<p>", "");
		site = site.replaceAll("</p>", "");
		site = Translate.decode(site);
		stopTimer("Downloaded site in ");
		startTimer();
		final ArrayList<String> sites = new ArrayList<String>();
		new AbstractPerform("title", site) {
			@Override
			public void perform(Node node) {
				new AbstractPerform(node.getChildren()) {
					@Override
					public void perform(Node node) {
						if (node.getText().equals("IMDb Title Search")) {
							new AbstractPerform("a", site) {
								@Override
								public void perform(Node node) {
									String href = getVal(node.getText(), "href");
									if (href.startsWith("/title/")) {
										if (!sites.contains(href))
											sites.add(href);
									}
								}
							};
						} else {
						}
					}
				};
			}
		};
		if (sites.size() == 0) {
			new AbstractPerform("meta", site) {
				@Override
				public void perform(Node node) {
					String txt = node.getText();
					// title
					if (getVal(txt, "name").equals("title")) {
						m.setName(getVal(txt, "content"));
					}
					// description
					if (getVal(txt, "name").equals("description")) {

						log(getVal(txt, "content"));
					}
				}
			};
			new AbstractPerform("script", site) {
				@Override
				public void perform(Node node) {
					if (node.getText().equals(
							"script type=" + '"' + "text/javascript" + '"')) {
						new AbstractPerform(node.getChildren()) {
							@Override
							public void perform(Node node) {
								String var = getVar(node.getText(), "__vrtg");
								if (var != null) {
									float rating;
									try {
										rating = Float.parseFloat(var);
									} catch (NumberFormatException nfe) {
										rating = 0;
									}
									m.setRating(rating);
									log("rating:" + var);
								}
							}

						};
					}
				}
			};
			new AbstractPerform("div", site) {

				@Override
				public void perform(Node node) {
					if (node.getText().equals(
							"div class=" + '"' + "photo" + '"')) {
						new AbstractPerform(node.getChildren()
								.extractAllNodesThatMatch(
										new TagNameFilter("a"))) {

							@Override
							public void perform(Node node) {
								Node photo = node.getFirstChild();
								if (photo != null) {
									m
											.setCoverURL(getVal(
													photo.getText(), "src"));
									log(getVal(photo.getText(), "src"));
								}
							}

						};
					}

				}
			};
			new AbstractPerform("h5", site) {
				@Override
				public void perform(Node node) {
					if (node.getFirstChild() != null) {
						String txt = node.getFirstChild().getText();
						Node par = node.getParent();
						if (txt.startsWith("Director")) {
							log("Director");
							new AbstractRecursivePerform(par.getChildren()) {
								@Override
								public void perform(Node node) {
									if (node.getText().startsWith("a")
											&& node.getFirstChild() != null) {
										m.addDirector(node.getFirstChild()
												.getText());
										log(node.getFirstChild().getText());
									}
								}
							};
						} else if (txt.startsWith("Writer")) {
							log("Writer");
							new AbstractPerform(par.getChildren()
									.extractAllNodesThatMatch(
											new TagNameFilter("a"))) {
								@Override
								public void perform(Node node) {
									if (node.getFirstChild() != null) {
										m.addWriter(node.getFirstChild()
												.getText());
										log(node.getFirstChild().getText());
									}
								}
							};
						} else if (txt.startsWith("Release Date")) {
							new AbstractRecursivePerform(node.getNextSibling()
									.getChildren()) {
								@Override
								public void perform(Node node) {
									if (node.getText().startsWith("p")
											&& node.getFirstChild() != null) {
										m.setReleaseDate(node.getFirstChild()
												.getText().replaceAll(
														"\n\b\r\t ", ""));
										log(node.getFirstChild().getText()
												.replaceAll("\n\b\r\t ", ""));
									}
								}
							};

						} else if (txt.startsWith("Genre")) {
							log("Genre:");
							new AbstractRecursivePerform(par.getChildren()) {
								@Override
								public void perform(Node node) {
									if (node.getText().startsWith("a")
											&& node.getFirstChild() != null) {
										m.addGenre(node.getFirstChild()
												.getText());
										log(node.getFirstChild().getText());
									}
								}
							};
						} else if (txt.startsWith("Tagline")) {
							log("Tagline");
							m.setTagline(node.getNextSibling().getText());
							log(node.getNextSibling().getText());
						} else if (txt.startsWith("Plot Keyword")) {
							log("Plot KeyWords:");
							Node span = par.getChildren()
									.extractAllNodesThatMatch(
											new TagNameFilter("div"))
									.elementAt(0).getFirstChild();
							new AbstractPerform(span.getChildren()
									.extractAllNodesThatMatch(
											new TagNameFilter("a"))) {
								@Override
								public void perform(Node node) {
									if (node.getFirstChild() != null) {
										m.addKeyword(node.getFirstChild()
												.getText());
										log(node.getFirstChild().getText());
									}
								}
							};
						} else if (txt.startsWith("Plot")) {
							log("Plot");
							new AbstractRecursivePerform(node.getNextSibling()
									.getChildren()) {
								@Override
								public void perform(Node node) {
									m.setPlot(node.getText());
									log(node.getText());
								}
							};

						} else if (txt.startsWith("Runtime")) {
							log("Runtime:");
							m.setRuntime(node.getNextSibling().getText());
							log(node.getNextSibling().getText());
						} else if (txt.startsWith("Countr")) {
							log("Country:");
							new AbstractRecursivePerform(par.getChildren()) {
								@Override
								public void perform(Node node) {
									if (node.getText().startsWith("a")
											&& node.getFirstChild() != null) {
										m.addCountry(node.getFirstChild()
												.getText());
										log(node.getFirstChild().getText());
									}
								}
							};
						} else if (txt.startsWith("Movie Connection")) {
							log("Movie Connections:");
							new AbstractRecursivePerform(par.getChildren()) {
								@Override
								public void perform(Node node) {
									if (node.getText().startsWith("a")
											&& node.getFirstChild() != null) {
										m.addMovieConnection(node
												.getFirstChild().getText());
										log(node.getFirstChild().getText());
									}
								}
							};
						}
					}
				}
			};
			// <h3>Cast</h3>
			new AbstractPerform("table", site) {
				@Override
				public void perform(Node node) {
					if (node.getText().equals(
							"table class=" + '"' + "cast" + '"')) {
						new AbstractPerform(node.getChildren()) {
							@Override
							public void perform(Node node) {
								new AbstractPerform(node.getChildren()) {
									@Override
									public void perform(Node node) {
										if (node.getText().startsWith(
												"td class=" + '"' + "nm" + '"')) {
											m.addActor(node.getFirstChild()
													.getFirstChild().getText());
										}
									}
								};
							}
						};
					}
				}
			};
			stopTimer("Parsed in ");
		} else {
			log("multiple sites");
			m.setDecided(false);
			for (String s : sites)
				m.addPossibleSite(s);
			m = new MovieFactory(m.getFileLocation()).getMovie(new URL(m
					.getPossibleSites().get(0)));
		}
		return m;
	}

	private void stopTimer(String string) {
		log(string + (System.currentTimeMillis() - startTime) + " ms");
	}

	private void startTimer() {
		this.startTime = System.currentTimeMillis();
	}

	private void log(String s) {
		if (LOGGING)
			System.out.println(s);
	}

	public Movie getMovie(String key) throws MalformedURLException,
			URISyntaxException, IOException {
		String url = IMDB_SEARCH + format(key);
		return getMovie(new URL(url));
	}

	private static String format(String key) {
		return key.replace(' ', '+');
	}

	private StringBuffer getData(URL url) throws IOException {
		URLConnection urlc = url.openConnection();
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

	private String getVal(String txt, String key) {
		Scanner s = new Scanner(txt);
		s.useDelimiter(" ");
		while (s.hasNext()) {
			String tmp = s.next();
			if (tmp.startsWith(key)) {
				while (tmp.charAt(tmp.length() - 1) != '"')
					tmp += " " + s.next();
				String[] arr = tmp.split('"' + "");
				if (arr.length > 1)
					return arr[1];
				else
					return "";
			}
		}
		return "";
	}

	private String getVar(String text, String var) {
		int start = text.indexOf(var);
		if (start == -1)
			return null;
		String value = text.substring(start + var.length()).split("'")[1];
		return value;
	}
}
