package mvcMovieComposite;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import movie.Movie;
import mvcMovieList.CMovieList;
import mvcMovieList.CMovieListSwing;
import mvcMovieManager.CMovieManager;
import mvcMovieManager.CMovieManagerSwing;

import oldgui.Appearance;

import org.eclipse.swt.widgets.Composite;

import system.Files;
import system.OS;

public class CMovieCompositeSwing extends CMovieComposite implements
		ActionListener, MouseListener {

	private GMovieCompositeSwing gui;

	public CMovieCompositeSwing(CMovieManagerSwing parent) {
		super(parent);
		this.gui = new GMovieCompositeSwing();
		super.init();
		parent.getGUI().add(gui, "0,2,f,f");
	}

	private void updateUI() {
		gui.setBorder(BorderFactory.createLineBorder(Color.black));
		gui.jLabel1.addMouseListener(this);
		GMovieInformationSwing comp = gui.gMovieInformationSwing1;
		Movie m = model.getMovie();
		comp.jTextField1.setText(m.getName());
		String dir = Appearance.handleList(m.getDirector());
		if (m.getWriter().size() > 0)
			dir += ", written by " + Appearance.handleList(m.getWriter());
		comp.jLabel1.setText(dir);
		comp.jProgressBar1.setValue((int) (m.getRating() * 10));
		comp.jButton1.setText(m.getImdbURL());
		comp.jButton1.addActionListener(this);
		comp.jButton1.setEnabled(true);
		comp.jLabel2.setText(m.getRuntime());
		comp.jLabel3.setText(Appearance.handleList(m.getActors()));
		comp.jTextPane1.setText(m.getPlot());
		if (model.getMovie().getCoverLocal() != null) {
			setImg();
		} else {
			gui.jLabel1.setIcon(new ImageIcon(Files.NO_POSTER));
		}
	}

	@Override
	protected void setImg() {
		ImageIcon ic = new ImageIcon(model.getMovie().getCoverLocal());
		gui.jLabel1.setIcon(ic);
	}

	public GMovieCompositeSwing getGui() {
		return gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// imdb link
		OS.browse(model.getMovie().getImdbURL());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// play
		System.out.println("asd1");
		model.getMovie().play();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public void showMovie(Movie movie) {
		model.setMovie(movie);
		updateUI();
	}

}
