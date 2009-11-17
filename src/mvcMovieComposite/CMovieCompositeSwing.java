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
import mvcMovieList.CMovieListSwing;

import oldgui.Appearance;

import org.eclipse.swt.widgets.Composite;

import system.Files;
import system.OS;

public class CMovieCompositeSwing extends CMovieComposite implements
		ActionListener, MouseListener {

	private GMovieCompositeSwing gui;

	public CMovieCompositeSwing(CMovieListSwing parent, Movie m) {
		super(parent, m);
		this.gui = new GMovieCompositeSwing();
		super.init();
		init2();
	}

	private void init2() {
		gui.setBorder(BorderFactory.createLineBorder(Color.black));
		gui.jLabel1.addMouseListener(this);
		GMovieInformationSwing comp = gui.gMovieInformationSwing1;
		Movie m = model.getMovie();
		comp.jTextField1.setText(m.getName());
		comp.jLabel1.setText(Appearance.handleList(m.getDirector())
				+ ", written by " + Appearance.handleList(m.getWriter()));
		comp.jProgressBar1.setValue((int) (m.getRating() * 10));
		comp.jButton1.setText(m.getImdbURL());
		comp.jButton1.addActionListener(this);
		comp.jButton1.setEnabled(true);
		comp.jLabel2.setText(m.getRuntime());
		comp.jLabel3.setText(Appearance.handleList(m.getActors()));
		if (model.coverLoaded()) {
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
		System.out.println("asd2");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("asd1");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("asd3");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("asd4");
	}

}
