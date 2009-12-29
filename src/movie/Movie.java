package movie;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import system.IO;
import system.OS;
import tools.GUIAccess;

public class Movie extends Observable implements Serializable,
		Comparable<Movie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5509501910602298144L;

	private List<List<String>> searchable;

	private String name;
	private String imdbURL;
	private float rating;
	private String coverURL;
	private String coverLocal;
	private String releaseDate;
	private String tagline;
	private String plot;
	private String runtime;
	private String fileLocation;
	private List<String> director;
	private List<String> writer;
	private List<String> keywords;
	private List<String> genre;
	private List<String> country;
	private List<String> movieConnections;
	private List<String> actors;
	private List<String> possibleSites;

	private boolean decided;

	public Movie() {
		decided = true;
		searchable = new ArrayList<List<String>>();
		director = new ArrayList<String>();
		searchable.add(director);
		writer = new ArrayList<String>();
		searchable.add(writer);
		genre = new ArrayList<String>();
		searchable.add(genre);
		keywords = new ArrayList<String>();
		searchable.add(keywords);
		country = new ArrayList<String>();
		searchable.add(country);
		movieConnections = new ArrayList<String>();
		searchable.add(movieConnections);
		actors = new ArrayList<String>();
		searchable.add(actors);
		possibleSites = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public String getImdbURL() {
		return imdbURL;
	}

	public float getRating() {
		return rating;
	}

	public String getCoverURL() {
		return coverURL;
	}

	public List<String> getDirector() {
		return director;
	}

	public List<String> getWriter() {
		return writer;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public List<String> getGenre() {
		return genre;
	}

	public String getTagline() {
		return tagline;
	}

	public String getPlot() {
		return plot;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public String getRuntime() {
		return runtime;
	}

	public List<String> getCountry() {
		return country;
	}

	public List<String> getMovieConnections() {
		return movieConnections;
	}

	public List<String> getActors() {
		return actors;
	}

	public void addMovieConnection(String mC) {
		movieConnections.add(mC);
	}

	public void setName(String name) {
		this.name = name;
		if (name == null || name.equals("")) {
			name = fileLocation;
		}
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setImdbURL(String imdbURL) {
		this.imdbURL = imdbURL;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setCoverURL(String coverURL) {
		this.coverURL = coverURL;
	}

	public void addDirector(String d) {
		director.add(d);
	}

	public void addWriter(String w) {
		writer.add(w);
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void addGenre(String g) {
		genre.add(g);
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public void addKeyword(String kw) {
		keywords.add(kw);
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public void addCountry(String c) {
		country.add(c);
	}

	@Override
	public String toString() {
		return "Movie [actors=" + actors + ", country=" + country
				+ ", coverLocal=" + coverLocal + ", coverURL=" + coverURL
				+ ", decided=" + decided + ", director=" + director
				+ ", fileLocation=" + fileLocation + ", genre=" + genre
				+ ", imdbURL=" + imdbURL + ", keywords=" + keywords
				+ ", movieConnections=" + movieConnections + ", name=" + name
				+ ", plot=" + plot + ", possibleSites=" + possibleSites
				+ ", rating=" + rating + ", releaseDate=" + releaseDate
				+ ", runtime=" + runtime + ", searchable=" + searchable
				+ ", tagline=" + tagline + ", writer=" + writer + "]";
	}

	public void addActor(String a) {
		actors.add(a);
	}

	public String getCoverLocal() {
		System.out.println("coverlocal: " + coverLocal);
		return coverLocal;
	}

	public void loadImg() {
		if (coverURL != null && coverLocal == null) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						coverLocal = IO.downloadToFile(coverURL, this
								.hashCode()
								+ ".jpg");
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					new GUIAccess() {
						@Override
						protected void execute() {
							downloadComplete();
						}
					};
				}
			}) {
			}.start();
		}
		if (coverLocal != null) {
			downloadComplete();
		}
	}

	protected void downloadComplete() {
		setChanged();
		notifyObservers();
	}

	public void setFileLocation(String loc) {
		this.fileLocation = loc;
	}

	public void play() {
		OS.start(fileLocation);
	}

	public void setDecided(boolean b) {
		this.decided = b;
	}

	public boolean isDecided() {
		return decided;
	}

	public void addPossibleSite(String s) {
		possibleSites.add("http://www.imdb.com" + s);
	}

	public List<String> getPossibleSites() {
		return possibleSites;
	}

	public boolean search(String key) {
		key = key.toLowerCase();
		for (List<String> l : searchable) {
			if (search(l, key)) {
				return true;
			}
		}
		ArrayList<String> strings = new ArrayList<String>();
		strings.add(name);
		strings.add(plot);
		strings.add(releaseDate);
		strings.add(runtime);
		strings.add(tagline);
		if (search(strings, key))
			return true;
		return false;
	}

	public boolean search(List<String> l, String key) {
		for (String s : l)
			if (s != null && s.toLowerCase().contains(key))
				return true;
		return false;
	}

	@Override
	public int compareTo(Movie o) {
		return Float.compare(o.rating, rating);
	}
}
