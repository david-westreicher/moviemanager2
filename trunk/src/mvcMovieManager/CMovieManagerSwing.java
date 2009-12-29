package mvcMovieManager;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import movie.Movie;
import mvcMovieComposite.CMovieCompositeSwing;
import mvcMovieList.CMovieList;
import mvcMovieList.CMovieListSwing;
import mvcMovieList.MMovieList;
import mvcSearchBar.CSearchBar;
import mvcSearchBar.CSearchBarSwing;
import mvcSearchBar.MSearchBar;

public class CMovieManagerSwing extends CMovieManager implements WindowListener {
	private GMovieManagerSwing gui;

	public CMovieManagerSwing(final List<Movie> movies, List<String> toScan) {
		super(movies, toScan);
		JFrame.setDefaultLookAndFeelDecorated(true);
		final CMovieManagerSwing inst = this;
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				gui = new GMovieManagerSwing();
				searchBar = new CSearchBarSwing(inst);
				movieList = new CMovieListSwing(inst);
				movieList.initMovies(movies);
				movieComposite = new CMovieCompositeSwing(inst);
				gui.setVisible(true);
				gui.addWindowListener(inst);
			}
		});

	}

	@Override
	public GMovieManagerSwing getGUI() {
		return gui;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		super.stop();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
