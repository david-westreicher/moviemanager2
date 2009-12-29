package mvcSearchBar;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mvcMovieManager.CMovieManager;
import mvcMovieManager.CMovieManagerSwing;

public class CSearchBarSwing extends CSearchBar implements DocumentListener {

	private JTextField gui;

	public CSearchBarSwing(CMovieManagerSwing par) {
		super(par);
		this.gui = new JTextField("");
		gui.getDocument().addDocumentListener(this);
		gui.setVisible(true);
		gui.setFont(new Font("Serif", Font.BOLD, 25));
		gui.setPreferredSize(new Dimension(500, 45));
		par.getGUI().getContentPane().add(gui, "0,0,f,c");
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		model.filterKeyChanged(gui.getText());
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		model.filterKeyChanged(gui.getText());
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		model.filterKeyChanged(gui.getText());
	}

}
